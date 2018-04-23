package com.ufab.servico;

import org.springframework.stereotype.Service;

import com.ufab.entidade.Aluno;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.AlunoValidacaoException;
import com.ufab.servico.inter.IAlunoServico;

@Service
public class AlunoServico implements IAlunoServico {

	@Override
	public void validarAluno(Aluno aluno) throws AlunoValidacaoException {
		if (aluno.getMatricula() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_MATRICULA.getValor());
		}
		if (aluno.getTipoNivelAluno() == null) {
			throw new AlunoValidacaoException(MensagensEnum.ALUNO_SERVICO_ERRO_AO_VALIDAR_NIVEL.getValor());
		}
	}

	@Override
	public String gerarMatricula(Aluno aluno) {
		return "MAT" + aluno.getCpf().substring(0, 4);
	}

}
