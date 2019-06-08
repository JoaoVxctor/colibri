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

    @GetMapping("/{id}")
    public String usuarioView(@PathVariable("id") Long id, Model model ) {
        model.addAttribute("usuario", usuarioService.findUsuarioById(id));
        return "";
    }


}
