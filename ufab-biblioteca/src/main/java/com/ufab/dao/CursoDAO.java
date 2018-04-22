package com.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ufab.entidade.Curso;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.CursoDaoException;

@Repository
@Transactional
public class CursoDAO implements ICursoDAO {

	private Logger LOGGER = Logger.getLogger(CursoDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void inserir(Curso c) throws CursoDaoException {
		getCurrentSession().save(c);
	}

	@Override
	public List<Curso> recuperarTodos() {
		return getCurrentSession().createQuery("FROM curso").list();
	}

	@Override
	public Curso recuperarPorCod(int cod) {
		return (Curso) getCurrentSession().createQuery("from curso where cod = :cod").setInteger("cod", cod)
				.uniqueResult();
	}

	@Override
	public void remover(Curso curso) {
		getCurrentSession().delete(curso);
	}

	@Override
	public void atualizar(Curso curso) {
		getCurrentSession().update(curso);
	}

}
