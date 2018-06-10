package com.ufab.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuxiliarControlador {
	
	@RequestMapping(value="/item")
	public ModelAndView tela1() {
		return new ModelAndView("item");
	}
	@RequestMapping(value="/dividas")
	public ModelAndView tela2() {
		return new ModelAndView("dividas");
	}
	@RequestMapping(value="/relatorio")
	public ModelAndView tela3() {
		return new ModelAndView("relatorio");
	}
	@RequestMapping(value="/reserva")
	public ModelAndView tela4() {
		return new ModelAndView("reserva");
	}
}
