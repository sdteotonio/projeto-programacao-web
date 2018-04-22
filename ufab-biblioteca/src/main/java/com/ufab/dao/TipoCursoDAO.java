package com.ufab.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ufab.dao.inter.ITipoCursoDAO;
import com.ufab.entidade.TipoCurso;

@Repository
public class TipoCursoDAO implements ITipoCursoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void inserir(TipoCurso tipoCurso) {
		getCurrentSession().save(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return getCurrentSession().createQuery("from tipocurso").list();
	}

}
