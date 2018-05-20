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
import com.ufab.entidade.Aluno;
import com.ufab.entidade.Funcionario;
import com.ufab.entidade.Usuario;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.enumerador.TipoPerfil;
import com.ufab.excecao.UfabUtilidadeException;
import com.ufab.excecao.UsuarioServicoException;
import com.ufab.servico.ICursoServico;
import com.ufab.servico.IPerfilServico;
import com.ufab.servico.IUsuarioServico;
import com.ufab.util.UfabUtilidade;

@Controller
public class UsuarioControlador {

	@Autowired
	private IUsuarioServico usuarioServico;

	@Autowired
	private IPerfilServico perfilServico;

	@Autowired
	private ICursoServico cursoServico;

	private Logger LOGGER = Logger.getLogger(UsuarioControlador.class);

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView indexUsuario(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/usuario");
		mv.addObject("usuarioAuth", usuarioServico.recuperarUsuarioAutenticado());
		mv.addObject("selectTipoUsu", perfilServico.recuperarTodos());
		return mv;
	}

	@RequestMapping(value = "/usuario/form", method = RequestMethod.GET)
	public ModelAndView getForm(Model model, @RequestParam(required = true, value = "tipoForm") String tipoForm,
			@RequestParam(required = false) String cpfUsu) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/form.usuario");
		mv.addObject("tipoForm", tipoForm);
		if (tipoForm.equals(TipoPerfil.ALUNO.name())) {
			mv.addObject("cursoAluno", cursoServico.recuperarTodos());
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

	@RequestMapping(value = "/usuario/tabela", method = RequestMethod.GET)
	public ModelAndView getTabela(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usuario/tabela.usuario");
		mv.addObject("usuarios", usuarioServico.recuperarTodos());
		return mv;
	}

	@RequestMapping(value = "/usuario/inserir", method = RequestMethod.POST, params = { "tipoForm" })
	public void inserirUsuario(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true, value = "tipoForm") String tipoForm) throws IOException {
		Usuario nUsuario = null;
		if (tipoForm.equals(TipoPerfil.ADMINISTRADOR.toString())) {
			nUsuario = new Administrador();
			nUsuario.setPerfil(perfilServico.recuperarPorTipo(TipoPerfil.ADMINISTRADOR));
		} else if (tipoForm.equals(TipoPerfil.ALUNO.toString())) {
			nUsuario = new Aluno();
			nUsuario.setPerfil(perfilServico.recuperarPorTipo(TipoPerfil.ALUNO));
			((Aluno) nUsuario).setNomeMae(request.getParameter("nomeDaMae"));
		}
		try {
			prepararObjetoUsuario(nUsuario, request);
			usuarioServico.inserir(nUsuario);
		} catch (UfabUtilidadeException e) {
			LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_RECUPERA_PARAMETRO.getValor(), e);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		} catch (UsuarioServicoException e) {
			LOGGER.error(MensagensEnum.CONTROLADOR_ERRO_AO_INSERIR.getValor(), e);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}

	}

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



