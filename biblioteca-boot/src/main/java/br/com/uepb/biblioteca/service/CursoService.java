package br.com.uepb.biblioteca.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.uepb.biblioteca.dao.CursoDAOImpl;
import br.com.uepb.biblioteca.enums.TipoFuncionario;
import br.com.uepb.biblioteca.exception.AutenticacaoException;
import br.com.uepb.biblioteca.exception.ExistException;
import br.com.uepb.biblioteca.model.Curso;
import br.com.uepb.biblioteca.model.Funcionario;

/**
 * Classe Service do Curso
 * 
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class CursoService {
	private static Logger logger = Logger.getLogger(CursoService.class);
	private CursoDAOImpl cursoDAO;
	//TODO: Retirar o excesso de log
	/**
	 * Cadastra o curso. So o admin que pode realizar essa funcionalidade, retornar
	 * o id salvo do banco
	 * 
	 * @param funcionariro
	 * @param curso
	 * @return
	 * @throws AutenticacaoException
	 * @throws ExistException
	 */
	public int cadastraCurso(Funcionario funcionario, Curso curso) throws AutenticacaoException, ExistException {
		cursoDAO = new CursoDAOImpl();
		if (cursoDAO.isExiste(curso)) {
			logger.warn("O curso ja existe, curso: " + curso);
			throw new ExistException("O Curso ja existe");
		}
		return cursoDAO.inserir(curso);
	}

	// TODO: Construido um metodo para atualizar o curso
	/**
	 * Atualiza o curso. So o admin que pode realizar essa funcionalidade
	 * 
	 * @param funcionariro
	 * @param curso
	 * @return
	 * @throws AutenticacaoException
	 * @throws ExistException
	 */
	public void atualizarCurso(Funcionario funcionario, Curso curso) throws AutenticacaoException, ExistException {
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			cursoDAO = new CursoDAOImpl();
			cursoDAO.atualizar(curso);
		}
	}

	/**
	 * Pegar todos os curso cadastrados no sistema
	 * 
	 * @return List
	 */
	public List<Curso> getListaCurso() {
		cursoDAO = new CursoDAOImpl();
		return cursoDAO.getLista();
	}

	/**
	 * Remova o curso. So o admin que pode realizar essa funcionalidade, retornar o
	 * id salvo do banco
	 * 
	 * @param funcionario
	 * @param curso
	 * @return
	 * @throws AutenticacaoException
	 */
	public boolean removerCurso(Funcionario funcionario, Curso curso) throws AutenticacaoException {
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			cursoDAO = new CursoDAOImpl();
			cursoDAO.remover(curso);
			return true;
		}
	}

	/**
	 * Pegar o curso pelo seu ID
	 * 
	 * @param idCurso
	 * @return Curso
	 */
	public Curso getCursoById(int idCurso) {
		cursoDAO = new CursoDAOImpl();
		return cursoDAO.getById(idCurso);
	}

}
