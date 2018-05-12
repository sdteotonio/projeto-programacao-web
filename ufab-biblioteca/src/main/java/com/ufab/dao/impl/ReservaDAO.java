package com.ufab.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.IReservaDAO;
import com.ufab.entidade.Reserva;

@Repository
@Transactional
public class ReservaDAO implements IReservaDAO {

	@Override
	public void inserir(Reserva reserva) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reserva> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Reserva reserva) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Reserva reserva) {
		// TODO Auto-generated method stub

	}

}
