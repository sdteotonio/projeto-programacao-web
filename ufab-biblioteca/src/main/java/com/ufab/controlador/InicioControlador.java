package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/***
 * Classe controladora da view inicial do sistema que possui métodos que são ações.
 * @author Bianca
 *
 */
@Controller
public class InicioControlador {

	
	/***
	 * Método que declara o valor da url "/" como index em todas as rotas da aplicação 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView recuperarTodosOsCursosT(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}

}
