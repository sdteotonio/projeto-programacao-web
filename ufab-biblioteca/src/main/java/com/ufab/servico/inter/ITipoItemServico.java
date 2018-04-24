package com.ufab.servico.inter;

import java.util.List;

import com.ufab.entidade.TipoItem;

public interface ITipoItemServico {
	/**
	 * @param tipoItem
	 *            Tipo de item que deseja ser cadastrado.
	 */
	public void inserir(TipoItem tipoItem);

	/**
	 * @return Uma lista de todos os tipos de item do sistema.
	 */
	public List<TipoItem> listarTodos();
}
