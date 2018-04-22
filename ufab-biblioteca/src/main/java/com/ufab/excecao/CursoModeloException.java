package com.ufab.excecao;

/**
 * Responsavel por estourar as excecoes do Modelo do curso, como falhas de processo e etc.
 * @author Davi
 *
 */
public class CursoModeloException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4421889896380330715L;

	public CursoModeloException(String msg) {
		super(msg);
	}
}
