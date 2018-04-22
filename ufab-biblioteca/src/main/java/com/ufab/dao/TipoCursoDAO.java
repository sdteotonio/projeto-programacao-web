package com.ufab.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufab.dao.inter.ITipoCursoDAO;
import com.ufab.entidade.TipoCurso;

@Repository
public class TipoCursoDAO extends DAO implements ITipoCursoDAO {

	@Override
	public void inserir(TipoCurso tipoCurso) {
		getCurrentSession().save(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return getCurrentSession().createQuery("from tipocurso").list();
	}

}
