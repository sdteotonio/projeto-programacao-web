package entidade;

import java.io.Serializable;

/***
 * Classe par objetos do tipo Curso, com valores e métodos para os mesmos.
 * @author Bianca
 *
 */
public class Curso implements Serializable {

	
	private static final long serialVersionUID = 3059184459770169333L;
	private int cod;
	private String nome;
	private String area;
	private TipoCurso tipoCurso;

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
