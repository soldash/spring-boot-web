package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexController {

	@RequestMapping(value = {"/index","","/","home"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";

	}

	/*
	 * @GetMapping("/index") public String index() {
	 * 
	 * return "index";
	 * 
	 * }
	 */

}
