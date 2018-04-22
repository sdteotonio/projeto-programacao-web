package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "curso")
@Table(name = "curso")

/**
 * Classe par objetos do tipo Curso, com valores e métodos para os mesmos.
 * 
 * @author Bianca
 *
 */
public class Curso implements Serializable {

	private static final long serialVersionUID = 3059184459770169333L;
	@Id
	@GeneratedValue
	private int cod;

	@Column(unique = true)
	private String nome;

	private String area;

	@ManyToOne
	@JoinColumn(name = "FK_TipoCurso_cod")
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
