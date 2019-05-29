package br.com.colibri.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grupo")

public class ProjetoController {
	
	@GetMapping("/novo")
	public String novo() {
		return "cadastrargrupo";
		
	}
	
}

