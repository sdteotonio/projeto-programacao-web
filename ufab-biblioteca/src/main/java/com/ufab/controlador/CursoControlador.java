package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.servico.ICursoServico;

@Controller
public class CursoControlador {

	@Autowired
	private ICursoServico cursoServico;

	@RequestMapping(value = "/curso", method = RequestMethod.GET)
	public ModelAndView recuperarTodosOsCursos(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("dash");
		return m;
	}
}