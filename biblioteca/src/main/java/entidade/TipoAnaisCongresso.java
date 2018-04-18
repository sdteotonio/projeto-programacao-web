package entidade;

import java.io.Serializable;

/***
 * Classe de objetos do tipo "tipo Anais de Congresso" , com seus respectivos valores e métodos.
 * @author Bianca
 *
 */
public class TipoAnaisCongresso implements Serializable{
	
	private static final long serialVersionUID = -4296178742676921434L;
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
