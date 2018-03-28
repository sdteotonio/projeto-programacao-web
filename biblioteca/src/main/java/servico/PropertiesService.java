package servico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import enumeador.MensagensEnum;

public class PropertiesService {
	private static Logger LOGGER = Logger.getLogger(PropertiesService.class);

	public static String getProp(String propiedade) {
		Properties props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("src/main/resources/app.properties");
			props.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			LOGGER.error(UtilidadeServico.gerarMensagemComErro(MensagensEnum.ERRO_AO_LER_ARQUIVO_PROPERTIES.getValor(),
					e.getMessage()));
		} catch (IOException e) {
			LOGGER.error(UtilidadeServico.gerarMensagemComErro(MensagensEnum.ERRO_AO_EXECUTAR_IO.getValor(),
					e.getMessage()));
		}
		
		String valorDaPropiedade = props.getProperty(propiedade);
		return valorDaPropiedade;

	}
}
