package com.ufab.dao;

import java.util.List;

import com.ufab.entidade.Perfil;

public interface IPerfilDAO {

	public void inserir(Perfil perfil);

	public List<Perfil> recuperarTodos();

}
