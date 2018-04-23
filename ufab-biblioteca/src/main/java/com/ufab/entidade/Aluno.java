package com.ufab.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ufab.enumerador.TipoNivelAluno;

/**
 * Representa os Alunos do sistemaa
 * 
 * @author Davi
 *
 */
@Entity(name = "aluno")
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "FK_Usuario_cpf")
public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = 2739350983865960294L;

	@Column(unique = true)
	private String matricula;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "aluno_curso", joinColumns = { @JoinColumn(name = "cpf_alu") }, inverseJoinColumns = {
			@JoinColumn(name = "cod_curso") })
	private List<Curso> cursos;

	@Enumerated(EnumType.STRING)
	private TipoNivelAluno tipoNivelAluno;

	@Column(name = "nome_mae")
	private String nomeMae;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public TipoNivelAluno getTipoNivelAluno() {
		return tipoNivelAluno;
	}

	public void setTipoNivelAluno(TipoNivelAluno tipoNivelAluno) {
		this.tipoNivelAluno = tipoNivelAluno;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

}
