package entidade;

import java.io.Serializable;

public class TipoCurso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6926900901277238142L;
	private int cod;
	private String nome;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
