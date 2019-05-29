package br.com.colibri.controllers;

import br.com.colibri.models.Usuario;
import br.com.colibri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    private UsuarioService usuarioService;

    @Autowired
    public CadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String cadastro(Usuario usuario) {
        return "register";
    }

    @PostMapping
    public String cadastrar(@Valid Usuario usuario, Errors erros, Model model, HttpServletRequest request) {
        if (erros.hasErrors()) {
            model.addAttribute("erros", erros);

            return "register";
        }
        if (usuarioService.findUsuarioByEmail(usuario.getEmail()) != null) {
            model.addAttribute("emailCadastrado", "usuario já existente");
            return "cadastro";
        } else {
            usuarioService.saveUsuario(usuario, request);
            return "redirect:/index";
        }
    }

}

