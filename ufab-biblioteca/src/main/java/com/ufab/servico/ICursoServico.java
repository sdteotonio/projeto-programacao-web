package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.Curso;
import com.ufab.excecao.CursoServicoException;

public interface ICursoServico {
	public List<Curso> recuperarTodos();

	public void inserir(Curso c) throws CursoServicoException;

	public Curso recuperarPorCod(int cod) throws CursoServicoException;

	public void remover(Curso curso);

	public void atualizar(Curso curso) throws CursoServicoException;
}
