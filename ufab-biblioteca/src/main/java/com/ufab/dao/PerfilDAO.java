package com.ufab.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ufab.dao.inter.IPerfilDAO;
import com.ufab.entidade.Perfil;
@Repository
@Transactional
public class PerfilDAO extends DAO implements IPerfilDAO, Serializable {

	private static final long serialVersionUID = 8859359766103745345L;

	@Override
	public void inserir(Perfil perfil) {
		getCurrentSession().saveOrUpdate(perfil);
	}

	@Override
	public List<Perfil> recuperarTodos() {
		return getCurrentSession().createQuery("FROM perfil").list();
	}

}
