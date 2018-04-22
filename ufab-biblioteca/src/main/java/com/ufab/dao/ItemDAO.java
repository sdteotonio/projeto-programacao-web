package com.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.inter.IItemDAO;
import com.ufab.entidade.Item;
import com.ufab.excecao.ItemServicoException;

@Repository
@Transactional
public class ItemDAO implements IItemDAO {

	@Override
	public void inserir(Item item) throws ItemServicoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Item recuperarPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Item item) throws ItemServicoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Item item) {
		// TODO Auto-generated method stub

	}

}
