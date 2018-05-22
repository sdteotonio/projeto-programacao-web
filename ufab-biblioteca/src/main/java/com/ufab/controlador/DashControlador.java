package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.servico.IUsuarioServico;

/***
 * Classe controladora da dash da aplicação que possui métodos que são ações no sistema.
 * @author Bianca
 *
 */
@Controller
public class DashControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	/***
	 *  Método invocado pela URL "/dash" que recupera do sistema o tipo de usuário autenticado  para montar a view
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @return  - retorna a view que está sendo chamada
	 */
	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public ModelAndView getDash(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dash");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		return mv;
	}
}
