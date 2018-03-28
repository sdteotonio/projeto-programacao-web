package enumeador;

public enum MensagensEnum {
	ERRO_AO_CONECTAR_MYSQL("Erro ao conectar a base de dados."), 
	ERRO_AO_EXECUTAR_SQL("Erro ao executar script SQL."), 
	ERRO_AO_LER_ARQUIVO_PROPERTIES("Arquivo .properties não está disponível."),
	ERRO_AO_EXECUTAR_IO("Erro ao tentar excutar uma operação de entrada/saída."), 
	ITEM_MODELO_O_ITEM_NAO_PODE_SER_NULO("O Item não pode ser Nullo."), 
	ITEM_MODELO_ERRO_AO_VALIDAR_ITEM("Erro ao validar Item."), 
	ITEM_MODELO_O_NOME_PODE_NAO_SER_NULO("O Item deve conter um nome."),
	ITEM_MODELO_O_TITULO_PODE_NAO_SER_NULO("O Item deve conter um título."),
	ITEM_MODELO_ITEM_JA_CADASTRADO("O Item informado já está cadastrado no sistema."),
	ITEM_MODELO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO("O Tipo de item deve ser informado."),
	
	CURSO_MODELO_O_CURSO_NAO_PODE_SER_NULO("O Curso não pode ser Nullo."), 
	CURSO_MODELO_ERRO_AO_VALIDAR_CURSO("Erro ao validar Curso."), 
	CURSO_MODELO_O_NOME_PODE_NAO_SER_NULO("O Curso deve conter um nome."),
	CURSO_MODELO_A_AREA_PODE_NAO_SER_NULO("O Curso deve conter uma área."),
	CURSO_MODELO_CURSO_JA_CADASTRADO("O Curso informado já está cadastrado no sistema."),
	CURSO_MODELO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO("O Tipo de Curso deve ser informado.");
	
	

	private String valor;

	MensagensEnum(String msg) {
		this.valor = msg;
	}

	public String getValor() {
		return this.valor;
	}
}
