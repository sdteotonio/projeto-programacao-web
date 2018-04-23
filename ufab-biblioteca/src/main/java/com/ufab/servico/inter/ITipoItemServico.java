package com.ufab.servico.inter;

import java.util.List;

import com.ufab.entidade.TipoItem;

public interface ITipoItemServico {
	public void inserir(TipoItem tipoItem);

	public List<TipoItem> listarTodos();
}
