import benutzer.Analyst;
import benutzer.Kunde;
import extern.Datenbank;


public class BenutzerErstellen {

	public static void main(String[] args) {
		
		Kunde k = new Kunde();
		k.setBenutzername("Gandalf");
		k.setAdresse("Auenland");
		k.setName("Gandalf");
		k.setPasswort("pw1");
		
		Datenbank.save(k);
		
		System.out.println(k.getBenutzername());
		
		
		Analyst a = new Analyst();
		a.setBenutzername("Manu");
		a.setAdresse("Königssträßle");
		a.setName("Manuel");
		a.setPasswort("12345");
		
		Datenbank.save(a);
		
		System.out.println(a.getBenutzername());
	}

}
