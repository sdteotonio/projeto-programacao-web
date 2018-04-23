package com.ufab.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "tipoitem")
@Table(name = "tipoitem")


/***
 * Classe de objetos do tipo "TipoItem", com seus respectivos valores e m�todos.
 * 
 * @author Bianca
 *
 */

public class TipoItem implements Serializable {

	private static final long serialVersionUID = -553068684884804242L;
	@Id
	@GeneratedValue
	private int cod;
	private String nome;
	@ManyToOne (cascade = {CascadeType.ALL})

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
