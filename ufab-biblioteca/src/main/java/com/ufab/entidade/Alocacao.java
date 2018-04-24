package com.ufab.entidade;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "alocacao")
@Table(name = "alocacao")
public class Alocacao {

	@EmbeddedId
	private AlocacaoPrimaryKey id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_cpf", referencedColumnName = "usuario_cpf", nullable = false, updatable = false, insertable = false)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_cod", referencedColumnName = "curso_cod", nullable = false, updatable = false, insertable = false)
	private Curso curso;

	public AlocacaoPrimaryKey getId() {
		return id;
	}

	public void setId(AlocacaoPrimaryKey id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
