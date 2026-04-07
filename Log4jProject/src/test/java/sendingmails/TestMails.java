package sendingmails;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestMails {

	public static void main(String[] args) throws AddressException, MessagingException {
	
		
		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);

	}
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
