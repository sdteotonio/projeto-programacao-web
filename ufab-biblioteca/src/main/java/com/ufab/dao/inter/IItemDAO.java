package com.ufab.dao.inter;

import java.util.List;

import com.ufab.entidade.Item;
import com.ufab.excecao.ItemServicoException;

public interface IItemDAO {

	public void inserir(Item item) throws ItemServicoException;

	public Item recuperarPorCodigo(int codigo);

	public List<Item> recuperarTodos();

	public void atualizar(Item item);

	public void remover(Item item);
}
