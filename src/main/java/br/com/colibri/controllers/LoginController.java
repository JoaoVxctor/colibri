package br.com.colibri.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.colibri.repositories.UsuarioRepository;

@Controller
public class LoginController {

	UsuarioRepository usuarioRepository;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
//		if (erro == 1) {
//			mv.addObject(erro);
//			System.out.println("erro");
//		}
		return mv;
	}
	/*
	 * @PostMapping("/login") public ModelAndView login( Model
	 * model, @ModelAttribute("usuario") Usuario usuario, Errors erros){
	 * ModelAndView mv = new ModelAndView(); if(erros.hasErrors()){
	 * mv.setViewName("view/pages/samples/login"); mv.addObject("erros",erros);
	 * return mv; }else{
	 * 
	 * 
	 * return null; }
	 * 
	 * }
	 */
}
