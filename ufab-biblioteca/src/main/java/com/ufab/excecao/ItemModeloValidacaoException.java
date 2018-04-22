package com.ufab.excecao;

/**
 * Responsavel por estourar os erros de validacao de um Item
 * @author Davi
 *
 */
public class ItemModeloValidacaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5652572492494883031L;

	public ItemModeloValidacaoException(String msg) {
		super(msg);
	}
}
