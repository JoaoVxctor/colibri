package br.com.colibri.controllers;

import javax.validation.Valid;

import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.colibri.config.SecurityConfigurations;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//	@Autowired
//	public CadastroController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
//		this.usuarioRepository = usuarioRepository;
//		this.passwordEncoder = passwordEncoder;
//	}

    @GetMapping
    public String cadastro(Usuario usuario) {
        return "view/pages/samples/register";
    }

    @PostMapping
    public String cadastrar(@Valid Usuario usuario, Errors erros, Model model, RedirectAttributes redirectAttributes) {
        if (erros.hasErrors()) {

            model.addAttribute("erros", erros);
            return "view/pages/samples/register";
        } else {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioRepository.save(usuario);
            return "index";
        }
    }

}

