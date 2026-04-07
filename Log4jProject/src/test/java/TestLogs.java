

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestLogs {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = LogManager.getLogger();
		
		
		
		log.info("This is an info log");
		log.error("This is an errorA log");
		log.debug("This is a debug log");
		/*import org.apache.log4j.PropertyConfigurator;*/
		/*
		 * Date d = new Date();
		 * 
		 * System.out.println(d.toString().replace(":", "_").replace(" ", "_"));
		 * System.setProperty("current.date", d.toString().replace(":",
		 * "_").replace(" ", "_"));
		 * 
		 * PropertyConfigurator.configure(
		 * "./src/test/resources/properties/log4j.properties");
		 */
	
	}

}
