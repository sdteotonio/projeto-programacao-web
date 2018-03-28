package enumeador;

public enum MensagensEnum {
	ERRO_AO_CONECTAR_MYSQL("Erro ao conectar a base de dados."), 
	ERRO_AO_EXECUTAR_SQL("Erro ao executar script SQL."), 
	ERRO_AO_LER_ARQUIVO_PROPERTIES("Arquivo .properties n�o est� dispon�vel."),
	ERRO_AO_EXECUTAR_IO("Erro ao tentar excutar uma opera��o de entrada/sa�da.");

	private String valor;

	MensagensEnum(String msg) {
		this.valor = msg;
	}

	public String getValor() {
		return this.valor;
	}
}
