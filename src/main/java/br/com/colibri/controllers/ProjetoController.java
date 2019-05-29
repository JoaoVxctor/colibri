package br.com.colibri.controllers;

import br.com.colibri.services.ProjetoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grupo")

public class ProjetoController {
	private ProjetoService projetoService;
	@GetMapping("/novo")
	public String novo() {
		return "cadastrargrupo";
	}
	@PostMapping("/novo")
	public String novoProjeto(){
		return"index";
	}
	
}

