package com.ufab.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.entidade.Locacao;
import com.ufab.servico.ILocacaoServico;
import com.ufab.servico.IUsuarioServico;

/***
 * Classe controladora de locação que possui métodos que são ações no sistema
 * @author Bianca
 *
 */
@Controller
public class LocacaoControlador {
	
		@Autowired
		private ILocacaoServico locacaoServico;
		
		@Autowired
		private IUsuarioServico usuarioServico;
		
		/***
		 * Método invocado pela URL "/locacao/tabela" que recupera do sistema todas as locações do sistema
		 * @param model - Auxiliar que ajudará a adicionar atributos a view criada
		 * @return - retorna a view que está sendo chamada
		 */
		@RequestMapping(value = "/locacao/tabela", method = RequestMethod.GET)
		public ModelAndView getTabela(Model model) {
			ModelAndView modv = new ModelAndView();
			modv.setViewName("locacao/tabela.locacao");
			modv.addObject("locacoes", locacaoServico.listarTodas());
			return modv;
		}
		
		/***
		 * Método invocado pela URL "/locacao" que recupera do sistema o usuário autenticado 
		 * @param model - Auxiliar que ajudará a adicionar atributos a view criada
		 * @return - retorna a view que está sendo chamada
		 */
		@RequestMapping(value = "/locacao", method = RequestMethod.GET)
		public ModelAndView indexLocacao(Model model) {
			ModelAndView modv = new ModelAndView();
			modv.setViewName("locacao/locacao");
			modv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
			return modv;
		}
		
        /***
         * Método invocado pela URL "/locacao/inserir" responsável por inserir uma locação
         * @param model - Auxiliar que ajudará a adicionar atributos a view criada
         * @return - retorna a view que está sendo chamada 
         */
		@RequestMapping(value = "/locacao/inserir", method = RequestMethod.POST)
		public ModelAndView inserirAlocaco(Model model) {
			ModelAndView modv = new ModelAndView();
			
			return modv;
		}
		
		/***
		 * Método invocado pela URL "/locacao/form" que faz um GET no formulario
		 * @param model  - Auxiliar que ajudara a adicionar atributos a view criada
		 * @param tipoForm  - parâmetro do tipo String
		 * @return - retorna a view que está sendo chamada
		 */
		@RequestMapping(value = "/locacao/form", method = RequestMethod.GET)
		public ModelAndView getForm(Model model, @RequestParam(required = false) String tipoForm) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("locacao/form.locacao");
			mv.addObject("tipoForm", tipoForm);
			return mv;
		}
		
		
}
