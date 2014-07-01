package extern;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import benutzer.Benutzer;


/**
 * Bietet die Möglichkeit Benutzer über bestimmte Ereignisse per E-Mail zu
 * benachrichtigen.
 * 
 * @author Manuel Weber
 * 
 */
public class EmailBenachrichtigung {

	/**
	 * Sendet eine automatisierte E-Mail an einen Nutzer. Der Methode wird ein
	 * Objekt vom Typ Benutzer und ein String mit dem jeweiligen Ereignis
	 * übergeben. Aus dem Benutzer Objekt wird die jeweilige E-Mail-Adresse
	 * extrahiert an die die E-Mail gesendet wird.
	 * 
	 * @param benutzer
	 * @param ereignis
	 * 
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void eMailSenden(Benutzer benutzer, String ereignis) throws AddressException, MessagingException {
		
		String empfaenger = benutzer.geteMail();
		String betreff = "pRAT - Ereignisbenachrichtigung";
		String text = ereignis;

		EmailAccount account = EmailAccount.ACCOUNT;
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", account.getSmtp());
		properties.put("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port",
				String.valueOf(account.getPort()));
		properties.setProperty("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties,
				account.getPasswortAuthentifizierung());

		MimeMessage nachricht = new MimeMessage(session);
		nachricht.setFrom(new InternetAddress(account.getEmail()));
		nachricht.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(empfaenger, false));
		nachricht.setSubject(betreff);
		nachricht.setText(text);

		Transport.send(nachricht);

		System.out.println("E-Mail verdsandt");
	
	}
	
	/**
	 * Definiert einen E-Mail-Account von dem aus E-Mails versandt werden.
	 */
	private enum EmailAccount {

		// Account-daten
		ACCOUNT("aljechin2000", "c4manu93", "pRAT", "smtp.googlemail.com",
				587);

		private String benutzername;
		private String passwort;
		private String absender;
		private String smtp;
		private int port;

		/**
		 * Setzt die notwendigen Attribute des MailAccounts
		 * 
		 * @param benutzername
		 *            Benutzername beim E-Mail-Anbieter
		 * @param passwort
		 *            Passwort beim E-Mail-Anbieter
		 * @param absender
		 *            Absenderadresse
		 * @param smtp
		 *            SMTP-Server
		 * @param port
		 *            Port des SMTP-Servers
		 */
		private EmailAccount(String username,
				String password, String absender, String smtp, int port) {
			this.benutzername = username;
			this.passwort = password;
			this.absender = absender;
			this.smtp = smtp;
			this.port = port;
		}

		/* Getter- und Setter-Methoden */

		public String getEmail() {
			return absender;
		}

		public String getSmtp() {
			return smtp;
		}

		public int getPort() {
			return port;
		}

		public Authentifizierungsobjekt getPasswortAuthentifizierung() {
			return new Authentifizierungsobjekt(benutzername, passwort);
		}
	}
	
	/**
	 * Liefert ein Objekt zur Authentifizierung
	 */
	private static class Authentifizierungsobjekt extends Authenticator {
	    private String benutzername;
	    private String passwort;
	     
	    public Authentifizierungsobjekt (String benutzername, String passwort) {
	        this.benutzername = benutzername;
	        this.passwort = passwort;
	    }
	    
	    public PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(benutzername, passwort);
	    }
	}
}