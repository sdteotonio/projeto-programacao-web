package com.ufab.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufab.entidade.Curso;
import com.ufab.entidade.TipoCurso;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.CursoServicoException;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.ITipoCursoServico;
import com.ufab.servico.IUsuarioServico;

/***
 *  Classe controladora de curso que possui métodos que são ações no sistema.
 * @author Bianca
 *
 */
@Controller
public class CursoControlador {

	@Autowired
	private ICursoServico cursoServico;

	@Autowired
	private ITipoCursoServico tipoCursoServico;

	@Autowired
	private IUsuarioServico usuarioServico;
	
	private Logger LOGGER = Logger.getLogger(CursoControlador.class);
	
	
	/***
	 * Método invocado pela URL "/curso", responsável por recuperar o usuário logado.
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @return - Retorna a view que está sendo chamada (m)
	 */

	@RequestMapping(value = "/curso", method = RequestMethod.GET)
	public ModelAndView indexCurso(Model model) {
		ModelAndView m = new ModelAndView();
		m.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		m.setViewName("curso/curso");
		return m;
	}
	
	/***
	 * Método POST invocando pela URL "/curso/inserir" que faz inserção de curso no sistema
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @param req - requisição para o cliente
	 * @param res - resposta para o cliente
	 * @return - retorna a view que está sendo chamada (m)
	 */

	@RequestMapping(value = "/curso/inserir", method = RequestMethod.POST)
	public ModelAndView inserirCurso(Model model, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView m = new ModelAndView();
		Curso nCurso = new Curso();
		nCurso.setArea(req.getParameter("areaCurso"));
		nCurso.setNome(req.getParameter("nomeCurso"));
		nCurso.setTag(req.getParameter("tagCurso").toUpperCase());
		int tipoCursoCodigo = Integer.parseInt(req.getParameter("tipoCurso"));
		TipoCurso tpc = tipoCursoServico.recuperarPorCodigo(tipoCursoCodigo);
		nCurso.setTipoCurso(tpc);
		try {
			cursoServico.inserir(nCurso);
		} catch (CursoServicoException e) {
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_AO_INSERIR.getValor(), e);
		}

		m.setViewName("curso/curso");
		return m;
	}
	
	/***
	 * Método GET invocado pela URL "/curso/tabela" para retornar os cursos existentes no sistema, montando a 
	 * tabela de visualização com seus respectivos atributos.
	 * @param model  - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @return  - retorna a view que está sendo chamada (m)
	 */

	@RequestMapping(value = "/curso/tabela", method = RequestMethod.GET)
	public ModelAndView tabelaCurso(Model model) {
		ModelAndView m = new ModelAndView();
		m.setViewName("curso/curso.tabela");
		m.addObject("listaCursos", cursoServico.recuperarTodos());
		return m;
	}
	
	/***
	 * Método invocando pela URL "/curso/form" responsável por recuperar os cursos pelo código.
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @param cod - parâmetro 
	 * @param res - resposta para o cliente
	 * @return - Retorna a view que está sendo chamada (m)
	 */

	@RequestMapping(value = "/curso/form", method = RequestMethod.GET)
	public ModelAndView fomCurso(Model model, @RequestParam(value = "cod", required = false) Integer cod,HttpServletResponse res){
		ModelAndView m = new ModelAndView();
		m.setViewName("curso/curso.form");
		m.addObject("tipoCursoLista", tipoCursoServico.listarTodos());
		if (cod != null) {
			Curso c;
			try {
				c = cursoServico.recuperarPorCod(cod);
				m.addObject("curso", c);
			} catch (CursoServicoException e) {
				res.setStatus(HttpStatus.BAD_REQUEST.value());
				LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_DESCONHECIDO.getValor(), e);
			}
		}
		return m;
	}
	
	/***
	 * Método invocado pela URL "/curso/atualizar" responsável por atualizar um curso
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada.
	 * @param cod - Parâmetro
	 * @param req - requisição para o cliente
	 * @param res - resposta para o cliente
	 * @return - Retorna a view que está sendo chamada
	 */
	@RequestMapping(value = "/curso/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizarCurso(Model model, @RequestParam(value = "cod", required = true) Integer cod, HttpServletRequest req , HttpServletResponse res){
		ModelAndView m = new ModelAndView();
		m.setViewName("curso/curso.form");
		m.addObject("tipoCursoLista", tipoCursoServico.listarTodos());
		if (cod != null) {
			Curso nCurso;
			try {
				nCurso = cursoServico.recuperarPorCod(cod);
				
				nCurso.setArea(req.getParameter("areaCurso"));
				nCurso.setNome(req.getParameter("nomeCurso"));
				nCurso.setTag(req.getParameter("tagCurso").toUpperCase());
				int tipoCursoCodigo = Integer.parseInt(req.getParameter("tipoCurso"));
				TipoCurso tpc = tipoCursoServico.recuperarPorCodigo(tipoCursoCodigo);
				nCurso.setTipoCurso(tpc);
				try {
					cursoServico.atualizar(nCurso);
				} catch (CursoServicoException e) {
					res.setStatus(HttpStatus.BAD_REQUEST.value());
					LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_AO_INSERIR.getValor(), e);
				}
				
				m.addObject("curso", nCurso);
			} catch (CursoServicoException e) {
				res.setStatus(HttpStatus.BAD_REQUEST.value());
				LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_DESCONHECIDO.getValor(), e);
			}
		}
		return m;
	}

}