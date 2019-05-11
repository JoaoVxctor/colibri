package br.com.ifsp.interdisc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifsp.interdisc.models.Usuario;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public CadastroController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
    @GetMapping
    public String cadastro(){
        return "view/pages/samples/register";
    }
    
    @PostMapping
    public String cadastrar(@Valid Usuario usuario) {
    	return "home";
    }

}

