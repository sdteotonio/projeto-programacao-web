package com.ufab.servico;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.dao.inter.ITipoCursoDAO;
import com.ufab.entidade.TipoCurso;
import com.ufab.servico.inter.ITipoCursoServico;

@Service
@Transactional
public class TipoCursoServico implements ITipoCursoServico {

	@Autowired
	private ITipoCursoDAO iTipoCursoDAO;

	@Override
	public void inserir(TipoCurso tipoCurso) {
		iTipoCursoDAO.inserir(tipoCurso);
	}

	@Override
	public List<TipoCurso> listarTodos() {
		return iTipoCursoDAO.listarTodos();
	}
}
