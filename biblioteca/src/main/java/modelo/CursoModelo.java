package modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import entidade.Curso;
import enumeador.MensagensEnum;
import excecao.CursoModeloException;
import excecao.CursoModeloValidacaoException;
import servico.UtilidadeServico;

public class CursoModelo {

	private HashMap<String, Curso> hashDeCurso;

	private Logger LOGGER = Logger.getLogger(CursoModelo.class); 
	
	
	public CursoModelo() {
		this.hashDeCurso = new HashMap<String, Curso>();
	}

	
	/**
	 * @param curso
	 * 		Utilizado para inserir um curso no sistema
	 * @throws CursoModeloException
	 *      Caso ocorra algum erro ao inserir, seja por validação ou outro
	 *      tipo, será disparado uma exeception como esta.
	 */
	public void inserirCurso(Curso curso) throws CursoModeloException {
		try {
			validarCurso(curso);
			if (hashDeCurso.containsKey(curso.getNome())) {
				LOGGER.error(
						UtilidadeServico.gerarMensagemComErro(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor(),
								MensagensEnum.CURSO_MODELO_CURSO_JA_CADASTRADO.getValor()));
				throw new CursoModeloException(MensagensEnum.CURSO_MODELO_CURSO_JA_CADASTRADO.getValor());
			}
			hashDeCurso.put(curso.getNome(), curso);

		} catch (CursoModeloValidacaoException e) {
			LOGGER.error(UtilidadeServico
					.gerarMensagemComErro(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor(), e.getMessage()));
			throw new CursoModeloException(e.getMessage());
		}
	}

	
	/**
	 * @param curso
	 *            Curso recebido para validacao
	 * @throws CursoModeloValidacaoException
	 *             Caso seja detectado que o curso está inválido para inserção, uma
	 *             exception como esta será disparada.
	 */
	private void validarCurso(Curso curso) throws CursoModeloValidacaoException  {
		if (curso == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_O_CURSO_NAO_PODE_SER_NULO.getValor());
		}else if(curso.getNome() == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_O_NOME_PODE_NAO_SER_NULO.getValor());
		}else if(curso.getTipoCurso() == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO.getValor());
		}else if(curso.getArea() == null) {
			throw new CursoModeloValidacaoException(MensagensEnum.CURSO_MODELO_A_AREA_PODE_NAO_SER_NULO.getValor());
		}
	}
	
	
	
	/**
	 * @deprecated
	 * @param nome Nome do Curso que deseja recuperar
	 * @return Encontrando retorna com o objeto Curso, que contém o nome especificado
	 * @throws CursoModeloException lança exceção caso ocorra um erro na validação do curso
	 */
	public Curso recuperarCursoPorNome(String nome) throws CursoModeloException {
		if (nome == null) { 
			LOGGER.error(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
			throw new CursoModeloException(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
		}
		return hashDeCurso.get(nome);
	}

	
	
	
	/**
	 * @param curso Atualizar um curso 
	 * 		  Caso encontre o curso pelo nome especificado, atualiza.
	 * @throws CursoModeloException Lança exceção caso ocorra um erro na validacao do Curso
	 */
	public void atualizarCurso(Curso curso) throws CursoModeloException {
		try {
			validarCurso(curso);
			Curso cursoRecuperado = recuperarCursoPorNome(curso.getNome());
			hashDeCurso.put(cursoRecuperado.getNome(), curso);
		} catch (CursoModeloValidacaoException e) {
			LOGGER.error(UtilidadeServico
					.gerarMensagemComErro(MensagensEnum.CURSO_MODELO_ERRO_AO_VALIDAR_CURSO.getValor(), e.getMessage()));
			throw new CursoModeloException(e.getMessage());
		}
	}
	
	
	/**
	 * @deprecated
	 * @param curso Remover um curso passando seu Nome como chave 
	 * @return	Caso encontre remove o curso que tenha o nome especificado
	 * @throws CursoModeloException caso o Nome especificado seja inválido, lança uma exceção
	 */
	public Curso removerCursoPorNome(String nome) throws CursoModeloException {
		if (nome == null) {
			LOGGER.error(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
			throw new CursoModeloException(MensagensEnum.CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO.getValor());
		} 
		return hashDeCurso.remove(nome);
	
	}
	
}
