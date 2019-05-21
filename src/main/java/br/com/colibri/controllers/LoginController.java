package br.com.colibri.controllers;

import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.UsuarioRepository;
import org.apache.coyote.ErrorState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
 /*   @PostMapping("/login")
    public ModelAndView login( Model model, @ModelAttribute("usuario") Usuario usuario, Errors erros){
        ModelAndView mv = new ModelAndView();
        if(erros.hasErrors()){
            mv.setViewName("view/pages/samples/login");
            mv.addObject("erros",erros);
            return mv;
        }else{


            return null;
        }

    }*/
}
