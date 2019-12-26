package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/Index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "No presente la entrada") String texto,
			Model model) {
		model.addAttribute("Resultado", "El parametro enviado es " + texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("Resultado", "El saludo enviado es '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("Resultado", "El saludo enviado es '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

}
