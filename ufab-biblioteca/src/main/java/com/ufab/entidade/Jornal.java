package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "jornal")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")
public class Jornal extends Item implements Serializable {
	/**
	 * 
	 */
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
