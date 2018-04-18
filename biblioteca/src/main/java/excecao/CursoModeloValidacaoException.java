package excecao;

/**
 * Responsavel por estourar os erros de validação de um curso.
 * @author Davi
 *
 */
public class CursoModeloValidacaoException extends Exception {
	public CursoModeloValidacaoException(String msg) {
		super(msg);
 }
}
