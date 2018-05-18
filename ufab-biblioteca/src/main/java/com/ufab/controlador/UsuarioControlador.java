package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.enumerador.TipoPerfil;
import com.ufab.servico.IPerfilServico;
import com.ufab.servico.IUsuarioServico;

@Controller
public class UsuarioControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	@Autowired
	private IPerfilServico perfilServico;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView indexUsuario(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/usuario");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		mv.addObject("selectTipoUsu", perfilServico.recuperarTodos());
		mv.addObject("usuarios", usuarioServico.recuperarTodos());
		return mv;
	}

	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public ModelAndView getForm(Model model,@RequestParam(required=false) String tipoForm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/form.usuario");
		mv.addObject("tipoForm",tipoForm);
		return mv;
	}
}
