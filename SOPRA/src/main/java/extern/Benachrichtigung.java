package extern;

import benutzer.Benutzer;

/**
 * Bietet die Möglichkeit Benutzer über bestimmte Ereignisse per E-Mail zu
 * benachrichtigen.
 * 
 * @author Manuel Weber
 * 
 */
public class Benachrichtigung {

	/**
	 * Sendet eine automatisierte E-Mail an einen Nutzer. Der Methode wird ein
	 * Objekt vom Typ Benutzer und ein String mit dem jeweiligen Ereignis
	 * übergeben. Aus dem Benutzer Objekt wird die jeweilige E-Mail-Adresse
	 * extrahiert an die die E-Mail gesendet wird.
	 * 
	 * @param benutzer
	 * @param ereignis
	 */
	public static void sendeEmail(Benutzer benutzer, String ereignis) {

	}
}
