package br.com.colibri.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.colibri.repositories.UsuarioRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


	@GetMapping("/login")
	public String login() {

		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
}
