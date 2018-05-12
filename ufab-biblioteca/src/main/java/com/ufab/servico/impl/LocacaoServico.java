package com.ufab.servico.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufab.entidade.Locacao;
import com.ufab.excecao.LocacaoServicoException;
import com.ufab.servico.ILocacaoServico;

@Service
public class LocacaoServico implements ILocacaoServico{

	@Override
	public void inserir(Locacao locacao) throws LocacaoServicoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Locacao locacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Locacao> listarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Locacao locacao) throws LocacaoServicoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarLocacao(Locacao locacao) throws LocacaoServicoException {
		// TODO Auto-generated method stub
		
	}

}
