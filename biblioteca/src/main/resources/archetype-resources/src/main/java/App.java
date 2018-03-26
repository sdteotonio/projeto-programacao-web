package $com.ufab.tec.biblioteca;

import org.apache.logging.log4j.core.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Logger logger = Logger.getLogger(App.class);
        logger.error("Teste");
    }
}
