package com.ufab.enumerador;

/***
 * Enumerador contendo todas as mensagens que os sistema loga, ou apresenta para o usuário final.
 * @author Davi
 *
 */
public enum MensagensEnum {
	ERRO_AO_EXECUTAR_SQL("Erro ao executar script SQL."), 
	ITEM_SERVICO_O_ITEM_NAO_PODE_SER_NULO("O Item nao pode ser Nulo."), 
	ITEM_SERVICO_ERRO_AO_VALIDAR_ITEM("Erro ao validar Item."), 
	ITEM_SERVICO_O_NOME_PODE_NAO_SER_NULO("O Item deve conter um nome."),
	ITEM_SERVICO_O_TITULO_PODE_NAO_SER_NULO("O Item deve conter um titulo."),
	ITEM_SERVICO_ITEM_JA_CADASTRADO("O Item informado ja esta cadastrado no sistema."),
	ITEM_SERVICO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO("O Tipo de item deve ser informado."), 
	ITEM_SERVICO_PARAMETRO_DE_BUSCA_TITULO_VAZIO("O parametro titulo deve ser informado."),
	ITEM_SERVICO_ERRO_DESCONHECIDO("Erro desconhecido ao executar uma operacao relacionado ao Item."),
	ITEM_SERVICO_ERRO_PARAMETRO_ITEM_NULO("Um Item deve ser informado"),
	CURSO_SERVICO_O_CURSO_NAO_PODE_SER_NULO("O Curso nao pode ser Nulo."), 
	CURSO_SERVICO_ERRO_AO_VALIDAR_CURSO("Erro ao validar Curso."), 
	CURSO_SERVICO_O_NOME_PODE_NAO_SER_NULO("O Curso deve conter um nome."),
	CURSO_SERVICO_A_AREA_PODE_NAO_SER_NULO("O Curso deve conter uma area."),
	CURSO_SERVICO_CURSO_JA_CADASTRADO("O Curso informado ja esta cadastrado no sistema."),
	CURSO_SERVICO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO("O Tipo de Curso deve ser informado."),
	CURSO_SERVICO_PARAMETRO_DE_BUSCA_NOME_VAZIO("O parametro nome do curso deve ser informado."), 
	CURSO_SERVICO_ERRO_DESCONHECIDO("Erro desconhecido ao executar uma operacao relacionado ao Curso."), 
	CURSO_SERVICO_ERRO_PARAMETRO_CURSO_NULO("Um Curso deve ser informado.");
	

	private String valor;

	MensagensEnum(String msg) {
		this.valor = msg;
	}

	public String getValor() {
		return this.valor;
	}
}
