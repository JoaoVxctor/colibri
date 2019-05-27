package br.com.colibri.controllers;

import br.com.colibri.models.Usuario;
import br.com.colibri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = {"/index","/"})
public class IndexController {
	private UsuarioService usuarioService;

	@Autowired
	public IndexController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public String index(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		Long usuarioId = (Long) session.getAttribute("usuarioId");
		if(usuarioId == null){
			System.out.println("redirect : "+ session.toString());
			return "redirect:/login";
		}
		Usuario usuario = usuarioService.findUsuarioById(usuarioId);
		System.out.println(usuario.getEmail() + " "+ usuario.getNome());
		model.addAttribute("usuario", usuario);
		return "index";
	}
	

	

}
