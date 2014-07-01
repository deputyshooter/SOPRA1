package projektelemente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.*;

import extern.Datenbank;

/**
 * 
 * @author Manuel Weber
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Projekt {

	@Id
	private String bezeichnung;

	@ManyToOne
	private benutzer.Analyst analyst;
	@ManyToOne
	private benutzer.Kunde kunde;
	@OneToMany(
			mappedBy = "projekt")
	private Set<Anforderung> anforderungen;
	@OneToOne(
			mappedBy = "projekt")
	private Begriffslexikon begriffslexikon;
	@OneToOne(
			mappedBy = "projekt")
	private Aenderungshistorie aenderungshistorie;
	private Abnahmestatus abnahmestatus;

	public Projekt() {
		this.abnahmestatus = Abnahmestatus.offen;
		this.begriffslexikon = new Begriffslexikon();
		this.begriffslexikon.setProjekt(this);
		this.aenderungshistorie = new Aenderungshistorie();
		this.aenderungshistorie.setProjekt(this);
		// bezeichnung muss per setter gesetzt werden
	}

	/**
	 * Diese Methode erstellt eine neue Anforderung. Ihr wird ein String
	 * uebergeben, der die Bezeichnung der zu erstellenden Anforderung festlegt.
	 * 
	 * @param bezeichnung
	 * @exception IllegalArgumentException
	 *                wenn keine Bezeichnung �bergeben wird oder bereits eine
	 *                Anforderung mit der uebergebenen Bezeichnung existiert
	 */
	public void anforderungHinzufuegen(
			String bezeichnung) {
		if (bezeichnung == null)
			throw new IllegalArgumentException(
					"Die Bezeichnung der Anforderung darf nicht null sein");

		Iterator<Anforderung> i = this.anforderungen
				.iterator();
		while (i.hasNext()) {
			if (i.next()
					.getBezeichnung() == bezeichnung)
				throw new IllegalArgumentException(
						"Es existiert bereits eine Anforderung mit der"
								+ " uebergebenen Bezeichnung: "
								+ bezeichnung);
		}
		try {
			Anforderung a = new Anforderung();
			a.setProjekt(this);
			a.setAbnahmestatus(Abnahmestatus.offen);
			a.setBezeichnung(bezeichnung);
			Datenbank.save(a);
			System.out.println("neue Anforderung erstellt: " + bezeichnung);
		} catch (Exception e) {
			System.out.println("Anforderung konnte nicht erstellt werden " + e.getMessage());
		}
	}

	/**
	 * Mit dieser Methode kann eine alternative Anforderung zu einer anderen
	 * erstellt werden. Als Übergabewerte benötigt die Methode ein Objekt vom
	 * Typ Anforderung und eine Bezeichnung der alternativen Anforderung in Form
	 * eines Strings.
	 * 
	 * @param bezeichnung
	 * @param alternativeZu
	 */
	public void alternativeAnforderungHinzufuegen(
			String bezeichnung,
			Anforderung alternativeZu) {

	}

	/**
	 * Mithilfe dieser Methode kann der Abnahmestatus des Projektes auf
	 * „abgenommen“ (ein Wert des Aufzählungstyps Abnahmestatus) gesetzt
	 * werden. Dies ist nur möglich, falls bereits alle Anforderungen des
	 * Projekts abgeschlossen wurden, d.h. einen von „offen“ verschiedenen
	 * Abnahmestatus besitzen.
	 */
	public void abnehmen() {

	}

	public ArrayList<Anforderung> getAnforderungen() {
		ArrayList<Anforderung> liste = new ArrayList<Anforderung>();
		return liste;
	}

	/**
	 * Diese Methode berechnet den Fortschritt des Projektes in Prozent.
	 * Hierfür wird die Anzahl der bereits abgeschlossenen Anforderungen durch
	 * die Gesamtanzahl der Anforderungen geteilt, mit 100 multipliziert, auf
	 * eine ganze Zahl gerundet und als Integer-Wert zurückgegeben
	 * 
	 * @return Integer-Wert für den berechneten Fortschritt
	 */
	public int berechneFortschritt() {

		return 0;
	}

	/**
	 * Diese Methode berechnet mit einer Formel einen geschätzten Gesamtnutzen
	 * in Prozent. In die Berechnung gehen die Bewertungen die der Kunde für
	 * die einzelnen Anforderungen tätigt und die Priorität die diese für den
	 * Nutzer besitzen ein: Formel: ∑ (prioritaet × bewertung) / ∑
	 * (prioritaet × 10) ×100 Wertebereiche: Priorität: niedrig = 1; mittel =
	 * 3; hoch = 9 Bewertung: [1,…,10]
	 * 
	 * @return Integer-Wert für den berechneten Nutzen
	 */
	public int berechneNutzen() {

		return 0;
	}

	/* Getter- und Setter-Methoden */

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(
			String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Abnahmestatus getAbnahmestatus() {
		return abnahmestatus;
	}

	public void setAbnahmestatus(
			Abnahmestatus abnahmestatus) {
		this.abnahmestatus = abnahmestatus;
	}

	public Begriffslexikon getBegriffslexikon() {
		return begriffslexikon;
	}

	public void setBegriffslexikon(
			Begriffslexikon begriffslexikon) {
		this.begriffslexikon = begriffslexikon;
	}

	public Aenderungshistorie getAenderungshistorie() {
		return aenderungshistorie;
	}

	public void setAenderungshistorie(
			Aenderungshistorie aenderungshistorie) {
		this.aenderungshistorie = aenderungshistorie;
	}

	public void setAnforderungen(
			Set<Anforderung> anforderungen) {
		this.anforderungen = anforderungen;
	}

	public benutzer.Analyst getAnalyst() {
		return analyst;
	}

	public void setAnalyst(benutzer.Analyst analyst) {
		this.analyst = analyst;
	}

	public benutzer.Kunde getKunde() {
		return kunde;
	}

	public void setKunde(benutzer.Kunde kunde) {
		this.kunde = kunde;
	}
	
	

}
