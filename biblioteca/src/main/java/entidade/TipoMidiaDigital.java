package entidade;

import java.io.Serializable;

/***
 * Classe e de objetos do tipo "TipoMidiaDigital", com seus respectivos valores e métodos.
 * @author Bianca
 *
 */
public class TipoMidiaDigital implements Serializable{

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
