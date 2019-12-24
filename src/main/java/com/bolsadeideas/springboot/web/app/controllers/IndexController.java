package com.bolsadeideas.springboot.web.app.controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping(value = { "/index", "", "/", "home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con Model");
		return "index";

	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Santiago");
		usuario.setApellido("Arismendi");
		usuario.setEmail("soldash@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Santiago", "Peña", "soldash@gmail.com"),
				new Usuario("Sharon", "López", "Sharon@gmail.com"),
				new Usuario("Manuel", "Motta", "Manuel@gmail.com"),
				new Usuario("Kevin", "López", "Kevin@gmail.com"));
		return usuarios;
	}

}
