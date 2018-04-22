package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipomidiadigital")
/***
 * Classe e de objetos do tipo "TipoMidiaDigital", com seus respectivos valores e m�todos.
 * @author Bianca
 *
 */
public class TipoMidiaDigital implements Serializable{
	private static final long serialVersionUID = 3940390738051218355L;
	@Id
	@GeneratedValue
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
