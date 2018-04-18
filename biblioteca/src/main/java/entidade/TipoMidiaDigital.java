package entidade;

import java.io.Serializable;

public class TipoMidiaDigital implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3940390738051218355L;
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
