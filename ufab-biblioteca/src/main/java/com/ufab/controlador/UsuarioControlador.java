package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.servico.IUsuarioServico;

@Controller
public class UsuarioControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView indexUsuario(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		return mv;
	}
}
