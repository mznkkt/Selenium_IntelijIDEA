import org.apache.log4j.Logger;

public class TestLog {
	
	
	static Logger log = Logger.getLogger(TestLog.class);
	
	public static void main(String[] args) {
		
		log.debug("This is a debug log");
		log.info("This is an info log");
		log.error("Error in a project");
		
		
	}

}
