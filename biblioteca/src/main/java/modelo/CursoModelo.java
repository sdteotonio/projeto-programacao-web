package modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import entidade.Curso;
import enumerador.MensagensEnum;
import excecao.CursoModeloException;
import excecao.CursoModeloValidacaoException;

/**
 * Responsavel por gerenciar todas as acoes que trabalham com Curso
 * 
 * @author Davi
 *
 */
public class CursoModelo {

	private HashMap<String, Curso> hashDeCurso;

	private Logger LOGGER = Logger.getLogger(CursoModelo.class);

	public CursoModelo() {
		this.hashDeCurso = new HashMap<String, Curso>();
	}

	/**
	 * Inserir um Curso no sistema
	 * 
	 * @param curso
	 *            Curso que deseja ser inserido no sistema.
	 * @throws CursoModeloException
	 *             Caso ocorra algum erro ao inserir, seja por valida��o ou outro
	 *             tipo, ser� disparado uma exeception como esta.
	 */
	public void inserirCurso(Curso curso) throws CursoModeloException {
		try {
			validarCurso(curso);
			if (hashDeCurso.containsKey(curso.getNome())) {
				LOGGER.warn(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor());
				throw new CursoModeloException(MensagensEnum.CURSO_MODELO_CURSO_JA_CADASTRADO.getValor());
			}
			hashDeCurso.put(curso.getNome(), curso);

		} catch (CursoModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor());
			throw new CursoModeloException(e.getMessage());
		}
	}

	/**
	 * Validar os parametros de um curso, para verificar se o mesmo está válido par
	 * utilização.
	 * 
	 * @param curso
	 *            Curso recebido para validacao
	 * @throws CursoModeloValidacaoException
	 *             Caso seja detectado que o curso est� inv�lido para inser��o, uma
	 *             exception como esta ser� disparada.
	 */
	private void validarCurso(Curso curso) throws CursoModeloValidacaoException {
		if (curso == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_O_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getNome() == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_O_NOME_PODE_NAO_SER_NULO.getValor());
		} else if (curso.getTipoCurso() == null) {
			throw new CursoModeloValidacaoException(
					MensagensEnum.CURSO_MODELO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO.getValor());
		} else if (curso.getArea() == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_A_AREA_PODE_NAO_SER_NULO.getValor());
		}
	}

	/**
	 * Recuperar um curso de acordo com seu nome.
	 * 
	 * @param nome
	 *            Nome do Curso que deseja recuperar
	 * @return Encontrando retorna com o objeto Curso, que cont�m o nome
	 *         especificado
	 * @throws CursoModeloException
	 *             lan�a exce��o caso ocorra um erro na valida��o do curso
	 */
	public Curso recuperarCursoPorNome(String nome) throws CursoModeloException {
		if (nome == null) {
			LOGGER.error(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
			throw new CursoModeloException(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
		}
		return hashDeCurso.get(nome);
	}

	/**
	 * Atualizar os dados de um curso, sendo ele informado via parametro para o
	 * metodo.
	 * 
	 * @param curso
	 *            O Curso que deseja ser atualizado.
	 * @throws CursoModeloException
	 *             Lan�a excecao caso ocorra um erro na validacao do Curso
	 */
	public void atualizarCurso(Curso curso) throws CursoModeloException {
		try {
			validarCurso(curso);
			Curso cursoRecuperado = recuperarCursoPorNome(curso.getNome());
			hashDeCurso.put(cursoRecuperado.getNome(), curso);
		} catch (CursoModeloValidacaoException e) {
			LOGGER.warn(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor());
			LOGGER.error(e);
			throw new CursoModeloException(e.getMessage());
		}
	}

	/**
	 * Remover um curso informando seu nome.
	 * 
	 * @param curso
	 *            Curso que existe no sistema, e deseja ser removido
	 * @return Retorna com o curso removido, caso encontre-o.
	 * @throws CursoModeloException
	 *             caso o Nome especificado seja invalido, lanca uma excecao
	 */
	public Curso removerCursoPorNome(String nome) throws CursoModeloException {
		if (nome == null) {
			LOGGER.error(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
			throw new CursoModeloException(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
		}
		return hashDeCurso.remove(nome);

	}

}
