package observers.busqueda;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 


public class NotificarAdmin implements ObserverBusqueda{
	
	
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail("pepe","terminalPalermo");
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void generateAndSendEmail(String stringBuscado, String nombreTerminal) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("figueroa.a.mj@gmail.com"));
		generateMailMessage.setSubject("Excesp de tiempo de busqueda");
		String emailBody = "Las busquedas en la terminal: "+nombreTerminal +" estan tardando mas de lo esperado." + "<br><br> El texto ingresado de la busqueda fue: "+stringBuscado+"."+"<br>CentroDeNotificaciones";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "figueroa.a.mj@gmail.com", "seven15868");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	

	@Override
	public void update(String stringBuscado, String nombreTerminal, int cantPois,int segundosQueTardo) throws AddressException, MessagingException {
		if(segundosQueTardo>5){
			this.generateAndSendEmail(stringBuscado, nombreTerminal);			
		}		
	}
	
	

}
