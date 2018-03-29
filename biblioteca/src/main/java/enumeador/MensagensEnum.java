package enumeador;

public enum MensagensEnum {
	ERRO_AO_CONECTAR_MYSQL("Erro ao conectar a base de dados."), 
	ERRO_AO_EXECUTAR_SQL("Erro ao executar script SQL."), 
	ERRO_AO_LER_ARQUIVO_PROPERTIES("Arquivo .properties nao esta disponivel."),
	ERRO_AO_EXECUTAR_IO("Erro ao tentar excutar uma operacao de entrada/saida."), 
	ITEM_MODELO_O_ITEM_NAO_PODE_SER_NULO("O Item nao pode ser Nulo."), 
	ITEM_MODELO_ERRO_AO_VALIDAR_ITEM("Erro ao validar Item."), 
	ITEM_MODELO_O_NOME_PODE_NAO_SER_NULO("O Item deve conter um nome."),
	ITEM_MODELO_O_TITULO_PODE_NAO_SER_NULO("O Item deve conter um titulo."),
	ITEM_MODELO_ITEM_JA_CADASTRADO("O Item informado ja esta cadastrado no sistema."),
	ITEM_MODELO_O_TIPO_DE_ITEM_NAO_PODE_SER_NULO("O Tipo de item deve ser informado."), 
	ITEM_MODELO_PARAMETRO_DE_BUSCA_TITULO_VAZIO("O parametro titulo deve ser informado."),
	CURSO_MODELO_O_CURSO_NAO_PODE_SER_NULO("O Curso nao pode ser Nulo."), 
	CURSO_MODELO_ERRO_AO_VALIDAR_CURSO("Erro ao validar Curso."), 
	CURSO_MODELO_O_NOME_PODE_NAO_SER_NULO("O Curso deve conter um nome."),
	CURSO_MODELO_A_AREA_PODE_NAO_SER_NULO("O Curso deve conter uma area."),
	CURSO_MODELO_CURSO_JA_CADASTRADO("O Curso informado ja esta cadastrado no sistema."),
	CURSO_MODELO_O_TIPO_DE_CURSO_NAO_PODE_SER_NULO("O Tipo de Curso deve ser informado."),
	CURSO_MODELO_PARAMETRO_DE_BUSCA_NOME_VAZIO("O parâmetro nome do curso deve ser informado");
	

	private String valor;

	MensagensEnum(String msg) {
		this.valor = msg;
	}

	public String getValor() {
		return this.valor;
	}
}
