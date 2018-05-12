package com.ufab.entidade;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "reserva")
@Table(name = "reserva")
public class Reserva {

	@Embeddable
	private class ReservaPk implements Serializable {

		private static final long serialVersionUID = 6829845482778964616L;

		public ReservaPk(int codoItem, String cpfAlu) {
			super();
			this.codoItem = codoItem;
			this.cpfAlu = cpfAlu;
		}

		@Column(name = "codigo")
		private int codoItem;

		@Column(name = "usuario_cpf")
		private String cpfAlu;

	}

	@EmbeddedId
	private ReservaPk reservaPk;

	private Date dt_reserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_cpf", referencedColumnName = "usuario_cpf", nullable = false, updatable = false, insertable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo", referencedColumnName = "codigo", nullable = false, updatable = false, insertable = false)
	private Item item;
}
