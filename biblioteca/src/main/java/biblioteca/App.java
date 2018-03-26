package biblioteca;

import org.apache.log4j.Logger;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger(App.class);
	public void testLogger() {
		LOGGER.error("Teste");
	}

}
