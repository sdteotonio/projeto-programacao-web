package servico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import enumerador.MensagensEnum;

public class PropertiesService {
	private static Logger LOGGER = Logger.getLogger(PropertiesService.class);

	/**
	 * @param propiedade Propiedade do app.properties que deseja-se obter o valor.
	 * @return Valor da propriedade informada, caso exista.
	 */
	public static String getProp(String propiedade) {
		Properties props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("src/main/resources/app.properties");
			props.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_LER_ARQUIVO_PROPERTIES.getValor());
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.warn(MensagensEnum.ERRO_AO_EXECUTAR_IO.getValor());
			LOGGER.error(e);
		}
		
		String valorDaPropiedade = props.getProperty(propiedade);
		return valorDaPropiedade;

	}
}
