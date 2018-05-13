package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControlador {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginView(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("login");
		return m;
	}
}
