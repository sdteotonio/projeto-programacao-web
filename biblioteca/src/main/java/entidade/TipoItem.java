package entidade;

import java.io.Serializable;

public class TipoItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -553068684884804242L;
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
