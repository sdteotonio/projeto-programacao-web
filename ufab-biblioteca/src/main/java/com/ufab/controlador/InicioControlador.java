package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioControlador {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView recuperarTodosOsCursosT(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}

}
