package br.com.ifsp.interdisc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifsp.interdisc.models.Usuario;
import br.com.ifsp.interdisc.repositories.UsuarioRepository;

@Controller
public class ListarController {

	@Autowired
	
	private UsuarioRepository usuariosRepository;

	
	@RequestMapping("listarUsuarios")
	public String listarUsuarios(Model model) {
		Iterable<Usuario> findAll = usuariosRepository.findAll();		
		model.addAttribute("usuarios",findAll);
		return "listarUsuarios";
	}

}
