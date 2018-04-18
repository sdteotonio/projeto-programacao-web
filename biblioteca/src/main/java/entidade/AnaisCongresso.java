package entidade;

import java.io.Serializable;

/***
 * Classe para objetos  do tipo Anais de Congresso que herdam de item suas caracteríticas, 
 * com valores e métodos para os mesmos. 
 * 
 * @author Bianca
 */

public class AnaisCongresso extends Item implements Serializable{
	private static final long serialVersionUID = -4450914185431808017L;
	private String nomeCongresso;
	private int anoPublicacao;
	private String autor;
	private String local;
	private TipoAnaisCongresso tipoAnaisCongresso;
	
	public TipoAnaisCongresso getTipoAnaisCongresso() {
		return tipoAnaisCongresso;
	}
	public void setTipoAnaisCongresso(TipoAnaisCongresso tipoAnaisCongresso) {
		this.tipoAnaisCongresso = tipoAnaisCongresso;
	}
	public String getNomeCongresso() {
		return nomeCongresso;
	}
	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	
}
