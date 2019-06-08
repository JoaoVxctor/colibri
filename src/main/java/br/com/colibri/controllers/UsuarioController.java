package br.com.colibri.controllers;

import br.com.colibri.services.ProjetoService;
import br.com.colibri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private ProjetoService projetoService;
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(ProjetoService projetoService, UsuarioService usuarioService) {
        this.projetoService = projetoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String usuarioView(HttpSession session, Model model ) {
        model.addAttribute("usuario", usuarioService.findUsuarioById((Long) session.getAttribute("usuarioId")));
        return "usuario-view";
    }


}
