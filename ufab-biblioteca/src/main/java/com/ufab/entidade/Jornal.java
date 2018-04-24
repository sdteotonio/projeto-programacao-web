package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "jornal")
@Table(name = "jornal")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")

/***
 *  Classe de objetos do tipo jornal, que herdam do item suas caracter�sticas. 
 *  Com valores e metodos dos mesmos. 
 * @author Bianca
 *
 */

public class Jornal extends Item implements Serializable {
	
	private static final long serialVersionUID = -6797923940253789080L;
	private String edicao;
	private Date data;

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
