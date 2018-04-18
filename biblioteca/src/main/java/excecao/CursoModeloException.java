package excecao;

/**
 * Responsavel por estourar as excecoes do Modelo do curso, como falhas de processo e etc.
 * @author Davi
 *
 */
public class CursoModeloException extends Exception {
	public CursoModeloException(String msg) {
		super(msg);
	}
}
