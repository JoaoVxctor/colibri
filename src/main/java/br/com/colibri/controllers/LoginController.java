package br.com.colibri.controllers;

import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.UsuarioRepository;
import org.apache.coyote.ErrorState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/logon")
    public String login(@Valid Usuario usuario, Model model, Errors erros){
        if(erros.hasErrors()){
            model.addAttribute("erros",erros);
            return "login";
        }else{

            //usuarioRepository.findOne()
            return null;
        }

    }
}
