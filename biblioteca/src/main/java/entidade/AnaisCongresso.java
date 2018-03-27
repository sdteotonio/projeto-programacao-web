package entidade;


public class AnaisCongresso extends Item {
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
