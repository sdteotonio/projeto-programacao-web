package com.ufab.servico;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.ICursoDAO;
import com.ufab.entidade.Curso;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.CursoDaoException;
import com.ufab.excecao.CursoServicoException;
import com.ufab.excecao.CursoValidacaoException;

@Service
public class CursoServico implements ICursoServico {

	private final Logger LOGGER = Logger.getLogger(CursoServico.class);

	@Autowired
	private ICursoDAO cursoDao;

	@Autowired
	private ITipoCursoServico iTipoCursoServico;

	@Override
	public List<Curso> recuperarTodos() {
		return cursoDao.recuperarTodos();
	}

	@Override
	public void inserir(Curso c) throws CursoServicoException {
		try {
			validar(c);
			cursoDao.inserir(c);
		} catch (CursoValidacaoException e) {
			LOGGER.error(e);
			throw new CursoServicoException(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor());
		} catch (CursoDaoException e) {
			LOGGER.error(e);
			throw new CursoServicoException(MensagensEnum.CURSO_MODELO_CURSO_JA_CADASTRADO.getValor());
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CursoServicoException(MensagensEnum.CURSO_SERVICO_ERRO_DESCONHECIDO.getValor());
		}
	}

	@Override
	public Curso recuperarPorCod(int cod) throws CursoServicoException {
		return cursoDao.recuperarPorCod(cod);
	}

	@Override
	public void remover(Curso curso) {
		cursoDao.remover(curso);
	}

	@Override
	public void atualizar(Curso curso) throws CursoServicoException {
		cursoDao.atualizar(curso);
	}

	/**
	 * Validar os parametros de um curso, para verificar se o mesmo está válido par
	 * utilização.
	 * 
	 * @param curso
	 *            Curso recebido para validacao
	 * @throws CursoValidacaoException
	 *             Caso seja detectado que o curso est� inv�lido para inser��o, uma
	 *             exception como esta ser� disparada.
	 */
	private void validar(Curso curso) throws CursoValidacaoException {
		if (curso == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_MODELO_O_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getNome() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_MODELO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (curso.getTipoCurso() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_MODELO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getArea() == null) {
			throw new CursoValidacaoException(MensagensEnum.CURSO_MODELO_A_AREA_PODE_NAO_SER_NULO.getValor());
		}
	}

}