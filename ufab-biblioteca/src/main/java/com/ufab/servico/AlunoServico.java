package com.ufab.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufab.entidade.Alocacao;
import com.ufab.entidade.Aluno;
import com.ufab.enumerador.MensagensEnum;
import com.ufab.excecao.AlunoValidacaoException;
import com.ufab.servico.inter.IAlocacaoServico;
import com.ufab.servico.inter.IAlunoServico;
/***
 * Servico para tratar de todas as manipulacoes de negocio com o Aluno
 * 
 * @author Davi
 *
 */
@Service
public class AlunoServico implements IAlunoServico {

	private static final Object SEPARADOR_MATRICULA = "-";

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
	public String gerarMatricula(Alocacao alocacao, Aluno aluno) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(aluno.getTipoNivelAluno().getValor());
		stringBuilder.append(alocacao.getCurso().getTag());
		stringBuilder.append(SEPARADOR_MATRICULA);
		stringBuilder.append(alocacao.getId().getAno().substring(2, 4));
		stringBuilder.append(alocacao.getId().getPeriodo());
		stringBuilder.append(aluno.getCpf().substring(0, 4));
		return stringBuilder.toString();
	}

}
