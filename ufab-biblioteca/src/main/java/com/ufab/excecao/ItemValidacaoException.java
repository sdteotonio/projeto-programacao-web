package com.ufab.excecao;

/***
 * Responsável por estourar os erros de validacao de um item
 * @author Bianca
 *
 */
public class ItemValidacaoException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 3982634097263082891L;
	
		public ItemValidacaoException(String msg) {
			super (msg);
		}


}
