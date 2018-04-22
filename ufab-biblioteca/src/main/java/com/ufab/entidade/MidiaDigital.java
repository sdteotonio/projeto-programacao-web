package com.ufab.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "midiadigital")
@PrimaryKeyJoinColumn(name = "FK_Item_cod")
/***
 * Classe de objetos do tipo Midia Digital, que herdam as caracter�sticas do
 * Item, com valores e m�todos dos mesmos.
 * 
 * @author Bianca
 *
 */

public class MidiaDigital extends Item implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 2482943632687981431L;

	@Column(name = "data_gravacao")
	private Date dataGravacao;

	@ManyToOne
	@JoinColumn(name = "FK_TipoMidiaDigital_cod")
	private TipoMidiaDigital tipoMidiaDigital;

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public TipoMidiaDigital getTipoMidiaDigital() {
		return tipoMidiaDigital;
	}

	public void setTipoMidiaDigital(TipoMidiaDigital tipoMidiaDigital) {
		this.tipoMidiaDigital = tipoMidiaDigital;
	}

}