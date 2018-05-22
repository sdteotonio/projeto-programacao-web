package com.ufab.controlador;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

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

import com.ufab.entidade.Administrador;
import com.ufab.entidade.Alocacao;
import com.ufab.entidade.AlocacaoPrimaryKey;
import com.ufab.entidade.Aluno;
import com.ufab.entidade.Curso;
import com.ufab.entidade.Funcionario;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.enumerador.TipoNivelAluno;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.excecao.CursoServicoException;
import com.ufab.excecao.UfabUtilidadeException;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.servico.IAlocacaoServico;
import com.ufab.servico.IAlunoServico;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.IPerfilServico;
import com.ufab.servico.IUsuarioServico;
import com.ufab.util.UfabUtilidade;

/***
 * Classe controladora de Usuário que possui métodos que são ações no sistema
 * @author Bianca
 *
 */
@Controller
public class UsuarioControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	@Autowired
	private IPerfilServico perfilServico;

	@Autowired
	private ICursoServico cursoServico;

	@Autowired
	private IAlunoServico alunoServico;

	@Autowired
	private IAlocacaoServico alocacaoServico;

	private Logger LOGGER = Logger.getLogger(UsuarioControlador.class);
	
	/***
	 * Metodo invocado pela URL "/usuario" que retornao usuário autenticado e o seu perfil
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada
	 * @return - retorna a view que está sendo chamada
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView indexUsuario(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/usuario");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		mv.addObject("selectTipoUsu", perfilServico.recuperarTodos());
		return mv;
	}

	/***
	 * Método invocado pela URL "/usuario/form"  que recupera o perfil do usuário para definir o modelo do formulario a ser montado
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada
	 * @param tipoForm - parâmentro de formulario
	 * @param cpfUsu - parâmentro de busca
	 * @return - retorna a view que está sendo chamada 
	 */
	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public ModelAndView getForm(Model model, @RequestParam(required = true, value = "tipoForm") String tipoForm,
			@RequestParam(required = false) String cpfUsu) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/form.usuario");
		mv.addObject("tipoForm", tipoForm);
		if (tipoForm.equals(TipoPerfil.ALUNO.name())) {
			mv.addObject("cursoAluno", cursoServico.recuperarTodos());
			mv.addObject("selectNivelAluno", TipoNivelAluno.values());
		}

		if (cpfUsu != null) {
			if (tipoForm.equals(TipoPerfil.ADMINISTRADOR.name())) {
				Usuario adm = usuarioServico.recuperarPorCpf(cpfUsu);
				mv.addObject("usuario", adm);
			} else if (tipoForm.equals(TipoPerfil.ALUNO.name())) {
				Aluno al = (Aluno) usuarioServico.recuperarPorCpf(cpfUsu);
				mv.addObject("usuario", al);
			} else if (tipoForm.equals(TipoPerfil.FUNCIONARIO.name())) {
				Funcionario fu = (Funcionario) usuarioServico.recuperarPorCpf(cpfUsu);
				mv.addObject("usuario", fu);
			}
		}
		return mv;
	}

	/***
	 * Método invocado pela URL "/usuario/tabela"  que recupera a tabela de exibição de dados do usuário
	 * @param model - Auxiliar que ajudará a adicionar atributos a view criada
	 * @return - retorna a view que está sendo chamada 
	 */
	@RequestMapping(value = "/usuario/tabela", method = RequestMethod.GET)
	public ModelAndView getTabela(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/tabela.usuario");
		mv.addObject("usuarios", usuarioServico.recuperarTodos());
		return mv;
	}

	/***
	 * Metodo invocado pela URL "/usuario/inserir" que insere um usuário no sistema através do seu tipo, montando o 
	 * formulário especifico para a opção. 
	 * @param request - requisição ao cliente
	 * @param response - resposta ao cliente
	 * @param tipoForm - parametro do tipo string - formulario
	 * @throws IOException - validação do sistema,lançando a exceçao
	 */
	@RequestMapping(value = "/usuario/inserir", method = RequestMethod.POST, params = { "tipoForm" })
	public void inserirUsuario(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true, value = "tipoForm") String tipoForm) throws IOException {
		try {
			// Precisamos refatorar esse metodo, estÃ¡ um lixo.
			if (tipoForm.equals(TipoPerfil.ADMINISTRADOR.toString())) {
				Usuario nUsuario = null;
				nUsuario = new Administrador();
				nUsuario.setPerfil(perfilServico.recuperarPorTipo(TipoPerfil.ADMINISTRADOR));
				usuarioServico.inserir(nUsuario);
			} else if (tipoForm.equals(TipoPerfil.ALUNO.toString())) {
				Alocacao al = new Alocacao();
				Aluno nAluno = new Aluno();
				nAluno.setPerfil(perfilServico.recuperarPorTipo(TipoPerfil.ALUNO));
				nAluno.setNomeMae(request.getParameter("nomeDaMae"));
				nAluno.setTipoNivelAluno(TipoNivelAluno.valueOf(request.getParameter("tipoAluno")));
				try {
					prepararObjetoUsuario(nAluno, request);

					al.setAluno(nAluno);

					Curso c = cursoServico.recuperarPorCod(Integer.parseInt(request.getParameter("cursoAluno")));
					al.setCurso(c);

					String ano = request.getParameter("ano");
					String periodo = request.getParameter("periodo");
					al.setId(new AlocacaoPrimaryKey(ano, periodo, c.getCod(), nAluno.getCpf()));
					nAluno.setMatricula(alunoServico.gerarMatricula(al));
					usuarioServico.inserir(nAluno);
					alocacaoServico.inserir(al);
				} catch (NumberFormatException e) {
					LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_DESCONHECIDO.getValor(), e);
					response.setStatus(HttpStatus.BAD_REQUEST.value());
				} catch (CursoServicoException e) {
					LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_RECUPERAR_PARAMETRO.getValor(), e);
					response.setStatus(HttpStatus.BAD_REQUEST.value());
				} catch (UfabUtilidadeException e) {
					LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_RECUPERAR_PARAMETRO.getValor(), e);
					response.setStatus(HttpStatus.BAD_REQUEST.value());
				}
			}
		} catch (UsuarioServicoException e) {
			LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_AO_INSERIR.getValor(), e);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}

	}

	/**
	 * Método que monta o objeto usuário
	 * @param nUsuario 
	 * @param request
	 * @throws UfabUtilidadeException
	 */
	private void prepararObjetoUsuario(Usuario nUsuario, HttpServletRequest request) throws UfabUtilidadeException {

		nUsuario.setCpf(request.getParameter("cpf"));
		nUsuario.setDataCadastro(new Date().from(Instant.now()));
		nUsuario.setEndereco(request.getParameter("endereco"));
		nUsuario.setFone(request.getParameter("fone"));
		nUsuario.setNaturalidade(request.getParameter("naturalidade"));
		nUsuario.setNomeCompleto(request.getParameter("nome"));
		nUsuario.setRg(request.getParameter("rg"));
		nUsuario.setSenha(request.getParameter("senha"));
		nUsuario.setDataNascimento(UfabUtilidade.gerarDataPorString(request.getParameter("dtNascimento")));

	}
}
