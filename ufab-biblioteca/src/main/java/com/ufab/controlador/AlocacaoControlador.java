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

/***
 * Classe controladora de aloca  es que possui m todos que s o a  es no sistema.
 * @author Bianca
 *
 */

@Controller
public class AlocacaoControlador {
	
	@Autowired
	private ICursoServico cursoServico;
	
	@Autowired
	private IAlocacaoServico alocacaoServico;

	
	/***
	 * M todo M todo invocado pela URL "/alocacao/tabela"  respons vel por recuperar os cursos do sistema 
	 * @param model - Auxiliar que ajudar  a adicionar atributos a view criada.
	 * @return - retorna a view que est  sendo chamada (modv)
	 */
	@RequestMapping(value = "/alocacao/tabela", method = RequestMethod.GET)
	public ModelAndView getTabela(Model model) {
		ModelAndView modv = new ModelAndView();
		modv.setViewName("alocacao/tabela.alocacao");
		modv.addObject("cursos", cursoServico.recuperarTodos());
		return modv;
	}
	
	/***
	 * M todo M todo invocado pela URL "/alocacao/curso" respons vel por recuperar a lista de aloca ao do 
	 * curso de acordo com seu c digo de identifica  o
	 * @param model - Auxiliar que ajudar  a adicionar atributos a view criada.
	 * @param cod - Par metro de busca
	 * @return - retorna a view que est  sendo chamada (modv) 
	 */
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
