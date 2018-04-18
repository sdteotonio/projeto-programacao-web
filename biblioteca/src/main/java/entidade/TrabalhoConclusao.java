package entidade;

import java.io.Serializable;

public class TrabalhoConclusao extends Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4654520096435655910L;
	private String orientador;
	private String autor;
	private int anoDefesa;
	private String local;

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoDefesa() {
		return anoDefesa;
	}

	public void setAnoDefesa(int anoDefesa) {
		this.anoDefesa = anoDefesa;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
