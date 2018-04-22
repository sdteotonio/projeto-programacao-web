package com.ufab.dao.inter;

import java.util.List;

import com.ufab.entidade.TipoCurso;

public interface ITipoCursoDAO {
	public void inserir(TipoCurso tipoCurso);
	public List<TipoCurso> listarTodos();
}
