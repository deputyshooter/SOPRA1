package projektelemente;

import java.util.ArrayList;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.*;


/**
 * 
 * @author Manuel Weber
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Anforderung {

	@Id
	private String bezeichnung;

	@ManyToOne
	private Projekt projekt;

	private Prioritaet prioritaet;
	private String beschreibungsentwurf;
	private Abnahmestatus abnahmestatus;
	@OneToMany(mappedBy = "anforderung")
	private Set<Beschreibung> beschreibungen;
	@OneToMany(mappedBy = "alternativeZu")
	private Set<Anforderung> alternativen;
	@ManyToOne
	private Anforderung alternativeZu;

	/**
	 * Der Methode wird ein String übergeben. Sie erzeugt daraufhin ein neues
	 * Objekt vom Typ Beschreibung, das der Anforderung zugeordnet ist und den
	 * übergebenen String als Beschreibungstext annimmt. Daraufhin wird dem
	 * betroffenen Kunden eine Mitteilung per E-Mail gesendet. Hierfür wird auf
	 * die Klasse Benachrichtigung zurückgegriffen.
	 * 
	 * @param beschreibung
	 */
	public void beschreiben(String beschreibung) {

	}

	/**
	 * Der Methode wird ein Boolean übergeben, ob die Anforderung akzeptiert
	 * oder abgelehnt wurde, woraufhin der Abnahmestatus der Anforderung
	 * entsprechend geändert wird.
	 * 
	 * @param abgenommen
	 */
	public void abnehmen(boolean abgenommen) {

	}

	/**
	 * Gibt eine Liste aller Beschreibungen der Anforderung zurück.
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Beschreibung> getBeschreibungen() {

		ArrayList<Beschreibung> liste = new ArrayList<Beschreibung>();
		return liste;

	}

	/**
	 * Vergleicht die Zeitstempel aller, der Anforderung zugeordneten,
	 * Beschreibungen und gibt die Aktuellste zurück.
	 * 
	 * @return Beschreibung
	 */
	public Beschreibung getAktuelleBeschreibung() {

		return null;

	}

	/* Getter- und Setter-Methoden */

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public Prioritaet getPrioritaet() {
		return prioritaet;
	}

	public void setPrioritaet(Prioritaet prioritaet) {
		this.prioritaet = prioritaet;
	}

	public String getBeschreibungsentwurf() {
		return beschreibungsentwurf;
	}

	public void setBeschreibungsentwurf(String beschreibungsentwurf) {
		this.beschreibungsentwurf = beschreibungsentwurf;
	}

	public Abnahmestatus getAbnahmestatus() {
		return abnahmestatus;
	}

	public void setAbnahmestatus(Abnahmestatus abnahmestatus) {
		this.abnahmestatus = abnahmestatus;
	}

	public Set<Anforderung> getAlternativen() {
		return alternativen;
	}

	public void setAlternativen(Set<Anforderung> alternativen) {
		this.alternativen = alternativen;
	}

	public Anforderung getAlternativeZu() {
		return alternativeZu;
	}

	public void setAlternativeZu(Anforderung alternativeZu) {
		this.alternativeZu = alternativeZu;
	}

	public void setBeschreibungen(Set<Beschreibung> beschreibungen) {
		this.beschreibungen = beschreibungen;
	}

}
