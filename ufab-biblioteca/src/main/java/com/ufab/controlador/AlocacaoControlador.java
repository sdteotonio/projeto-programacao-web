package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.excecao.CursoServicoException;
import com.ufab.servico.IAlocacaoServico;
import com.ufab.servico.ICursoServico;


@Controller
public class AlocacaoControlador {
	
	@Autowired
	private ICursoServico cursoServico;
	
	@Autowired
	private IAlocacaoServico alocacaoServico;

	@RequestMapping(value = "/alocacao/tabela", method = RequestMethod.GET)
	public ModelAndView getTabela(Model model) {
		ModelAndView modv = new ModelAndView();
		modv.setViewName("alocacao/tabela.alocacao");
		modv.addObject("cursos", cursoServico.recuperarTodos());
		return modv;
	}
	
	@RequestMapping(value = "/alocacao/curso", method = RequestMethod.GET)
	public ModelAndView getCurso(Model model, @RequestParam(required = true, value = "cod") int cod) {
		ModelAndView modv = new ModelAndView();
		modv.setViewName("alocacao/curso.alocacao");
		try {
			modv.addObject("alocacoes", cursoServico.recuperarPorCod(cod).getAlocacoes());
		} catch (CursoServicoException e) {
			e.printStackTrace();
		}
		return modv;
	}
	 
}
