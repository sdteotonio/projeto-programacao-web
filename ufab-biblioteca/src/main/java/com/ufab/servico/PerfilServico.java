package com.ufab.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.inter.IPerfilDAO;
import com.ufab.entidade.Perfil;
import com.ufab.servico.inter.IPerfilServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com o Perfil
 * 
 * @author Davi
 *
 */
@Service
public class PerfilServico implements IPerfilServico {

	@Autowired
	private IPerfilDAO perfilDao;

	@Override
	public void inserir(Perfil perfil) {
		perfilDao.inserir(perfil);
	}

	@Override
	public List<Perfil> recuperarTodos() {
		return perfilDao.recuperarTodos();
	}

}
