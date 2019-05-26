package br.com.colibri.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = {"/index","/"})
public class IndexController {
	

	@GetMapping
	public String index(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> usuario = (List<String>) session.getAttribute("usuarioID");
		if(usuario == null)
			return "redirect:/login";
		model.addAttribute("usuario",usuario);
		return "index";
	}
	

	

}
