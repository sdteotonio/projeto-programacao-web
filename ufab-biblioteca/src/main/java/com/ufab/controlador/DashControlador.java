package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.servico.IUsuarioServico;

@Controller
public class DashControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public ModelAndView getDash(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dash");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		return mv;
	}
}
