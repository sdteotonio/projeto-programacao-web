package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/***
 * Classe controladora da view inicial do sistema que possui m todos que s o a  es.
 * @author Bianca
 *
 */
@Controller
public class InicioControlador {

	
	/***
	 * M todo que declara o valor da url "/" como index em todas as rotas da aplica  o 
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
