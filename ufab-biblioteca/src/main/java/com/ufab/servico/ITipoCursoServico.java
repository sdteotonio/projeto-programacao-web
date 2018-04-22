package com.ufab.servico;

import java.util.List;

import com.ufab.entidade.TipoCurso;

public interface ITipoCursoServico {
	public void inserir(TipoCurso tipoCurso);

	public List<TipoCurso> listarTodos();
}
