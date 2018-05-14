package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * Classe de objetos do tipo "TipoItem", com seus respectivos valores e metodos.
 * 
 * @author Bianca
 *
 */
@Entity(name = "tipoitem")
@Table(name = "tipoitem")
public class TipoItem implements Serializable {

	private static final long serialVersionUID = -553068684884804242L;
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
