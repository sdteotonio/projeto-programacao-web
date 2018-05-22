package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/***
 *  Classe controladora de login que possui todos que usuarios no sistema
 * @author Bianca
 *
 */
@Controller
public class LoginControlador {

	/***
	 * Metodo invocado pela URL "/login" que retorna a view de login
	 * @param model - Auxiliar que ajudar  a adicionar atributos a view criada
	 * @return - retorna a view que est  sendo chamada
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginView(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("login");
		return m;
	}

}
