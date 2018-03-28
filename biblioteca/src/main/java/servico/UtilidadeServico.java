package servico;

public class UtilidadeServico {
	//Classe para utilidades, tipo esse metodo
	
	
	/**
	 * @param msg Mensagem para o Logger ou exibicao para o usuario
	 * @param msgTecnica Mensagem tecnica do erro, podendo ser a mensagem da exception
	 * @return Retorna um String concatenada entre a mensagem e a mensagem tecnica
	 */ 
 	public static String gerarMensagemComErro(String msg, String msgTecnica) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(msg);
		stringBuilder.append(" | ");
		stringBuilder.append(msgTecnica);
		return stringBuilder.toString();
	}
}
