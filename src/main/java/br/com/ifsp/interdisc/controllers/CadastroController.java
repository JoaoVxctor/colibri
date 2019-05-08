package br.com.ifsp.interdisc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifsp.interdisc.models.Usuario;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String cadastro(){
        return "cadastro";
    }
    
    @PostMapping
    public String cadastrar(@Valid Usuario usuario) {
    	return "home";
    }

}

