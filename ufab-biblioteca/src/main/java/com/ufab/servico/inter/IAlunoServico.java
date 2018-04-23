package com.ufab.servico.inter;

import com.ufab.entidade.Aluno;
import com.ufab.excecao.AlunoValidacaoException;

public interface IAlunoServico {

	public void validarAluno(Aluno aluno) throws AlunoValidacaoException;
	public String gerarMatricula(Aluno aluno);
}
