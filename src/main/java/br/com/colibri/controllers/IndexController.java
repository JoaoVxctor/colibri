package br.com.colibri.controllers;

import br.com.colibri.models.Projeto;
import br.com.colibri.models.Usuario;
import br.com.colibri.services.ProjetoService;
import br.com.colibri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = {"/index","/"})
public class IndexController {
	private UsuarioService usuarioService;
	private ProjetoService projetoService;

	@Autowired
	public IndexController(UsuarioService usuarioService, ProjetoService projetoService) {
		this.usuarioService = usuarioService;
		this.projetoService = projetoService;
	}

	@GetMapping
	public String index(Model model, HttpSession session, Projeto projeto, RedirectAttributes redirectAttributes) {
		@SuppressWarnings("unchecked")
		Long usuarioId = (Long) session.getAttribute("usuarioId");
		if(usuarioId == null){
			System.out.println("redirect : "+ session.toString());
			return "redirect:/login";
		}
		Usuario usuario = usuarioService.findUsuarioById(usuarioId);
		model.addAttribute("usuario", usuario);
		model.addAttribute(redirectAttributes.getFlashAttributes());
		return "index";
	}
	

	

}
