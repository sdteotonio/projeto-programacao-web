package servico;

public class UtilidadeServico {
	public static String gerarMensagemComErro(String msg, String msgTecnica) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(msg);
		stringBuilder.append(" | ");
		stringBuilder.append(msgTecnica);
		return stringBuilder.toString();
	}
}
