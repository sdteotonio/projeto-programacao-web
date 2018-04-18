package excecao;

/**
 * Responsavel por estourar os erros de validacao de um Item
 * @author Davi
 *
 */
public class ItemModeloValidacaoException extends Exception {
	public ItemModeloValidacaoException(String msg) {
		super(msg);
	}
}
