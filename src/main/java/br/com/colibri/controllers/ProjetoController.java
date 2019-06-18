package br.com.colibri.controllers;

import br.com.colibri.models.Projeto;
import br.com.colibri.models.Usuario;
import br.com.colibri.services.ProjetoService;
import br.com.colibri.services.SprintService;
import br.com.colibri.services.TarefaService;
import br.com.colibri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {
    private ProjetoService projetoService;
    private UsuarioService usuarioService;
    private SprintService sprintService;
    private TarefaService tarefaService;

    @Autowired
    public ProjetoController(ProjetoService projetoService, UsuarioService usuarioService, SprintService sprintService, TarefaService tarefaService) {
        this.projetoService = projetoService;
        this.usuarioService = usuarioService;
        this.sprintService = sprintService;
        this.tarefaService = tarefaService;
    }

    @PostMapping("/novo")
    public String novoProjeto(Projeto projeto, RedirectAttributes redirectAttributes, HttpSession session) {
        int index = -1;
        List<Usuario> participantes = new ArrayList<Usuario>();
        try {
            projeto.setCriador(usuarioService.findUsuarioById((Long) session.getAttribute("usuarioId")));
            projeto.getParticipantes().add(0, projeto.getCriador());

            for (Usuario usuario : projeto.getParticipantes()) {
                if (usuario.getEmail() == null) {
                    index = projeto.getParticipantes().indexOf(usuario);
                } else if (usuario.getId() == null) {
                    participantes.add(usuario);
                }
            }

            if (index > 0)
                projeto.getParticipantes().remove(index);

            projeto.getParticipantes().removeAll(participantes);

            for (Usuario participante : participantes) {
                projeto.getParticipantes().add(usuarioService.findUsuarioByEmail(participante.getEmail()));
            }

            projeto.setDataCriacao(LocalDateTime.now());

            if (projetoService.novoProjeto(projeto)) {
                System.out.println("foi :>");
                String mensagem = "Projeto " + projeto.getId() + " - " + projeto.getNome() +" criado com sucesso";
                redirectAttributes.addFlashAttribute("msg",mensagem);
            } else {
                System.out.println("nn foi =<");
                redirectAttributes.addFlashAttribute("msg","Algo de errado ocorreu.");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return "redirect:/index";
    }

    @GetMapping("/{id}")
    public String projetoView(@PathVariable("id") Long id, Model model , HttpSession session){
        Projeto projeto = projetoService.findProjetoById(id);
        model.addAttribute("projeto",projeto);
        model.addAttribute("usuario", usuarioService.findUsuarioById((Long) session.getAttribute("usuarioId")));
//        model.addAttribute("sprints", )
        return "projeto-view";
    }

    @GetMapping
    public String usuarioProjeto(HttpSession session,Model model, RedirectAttributes redirectAttributes) {
        List<Projeto> projetos = projetoService.findProjetoByParticipante((Long) session.getAttribute("usuarioId"), 1000);
        Collections.reverse(projetos);
        model.addAttribute("projetos", projetos);
        model.addAttribute("msg", redirectAttributes.getFlashAttributes());
        model.addAttribute("usuario", usuarioService.findUsuarioById((Long) session.getAttribute("usuarioId")));
        return "all-projeto";
    }


}

