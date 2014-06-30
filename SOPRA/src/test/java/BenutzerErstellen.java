import benutzer.Kunde;
import extern.Datenbank;


public class BenutzerErstellen {

	public static void main(String[] args) {
		
		Kunde a = new Kunde();
		a.setBenutzername("Gandalf");
		a.setAdresse("Auenland");
		a.setName("Gandalf");
		a.setPasswort("pw1");
		
		Datenbank.save(a);
		
		System.out.println(a.getBenutzername());
	}

}
