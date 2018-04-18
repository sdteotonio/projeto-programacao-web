package entidade;

import java.io.Serializable;
import java.util.Date;

public class Revista extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1075557342519416764L;
	private int nmrPagina;
	private Date dataPublicacao;
	private String edicao;
	private String editora;
	public int getNmrPagina() {
		return nmrPagina;
	}
	public void setNmrPagina(int nmrPagina) {
		this.nmrPagina = nmrPagina;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
