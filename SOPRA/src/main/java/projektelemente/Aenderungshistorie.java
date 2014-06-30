package projektelemente;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.*;
import javax.persistence.*;
import benutzer.Benutzer;

/**
 * Die Klasse Aenderungshistorie verwaltet eine Liste aller stattgefundenen
 * Änderungen.
 * 
 * @author Manuel Weber
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Aenderungshistorie {

	@Id @GeneratedValue
	private int id;
	
	@OneToOne
	private Projekt projekt;
	
	/**
	 * Die innere Klasse Aenderung stellt die Datenstruktur der Aenderungen in
	 * der Aenderungsliste bereit.
	 */
	public class Aenderung {

		private Aenderung(Date zeitstempel, Benutzer benutzer, String ereignis) {
			this.zeitstempel = zeitstempel;
			this.benutzer = benutzer;
			this.ereignis = ereignis;
		}

		@Id
		private int id;
		
		private Date zeitstempel;
		private Benutzer benutzer;
		private String ereignis;
	}

	private ArrayList<Aenderung> aenderungsliste;

	Aenderungshistorie() {
		// todo
	
	}

	/**
	 * Fügt eine neue Änderung zur Änderungshistorie hinzu. Hierfür werden der
	 * Zeitpunkt der Änderung, der jeweilige Benutzer und ein Ereignistext
	 * übergeben.
	 * 
	 * @param zeitstempel
	 * @param benutzer
	 * @param ereignis
	 */
	public void aenderungHinzufuegen(Date zeitstempel, Benutzer benutzer,
			String ereignis) {

		aenderungsliste.add(new Aenderung(zeitstempel, benutzer, ereignis));

	}

	public ArrayList<Aenderung> getAenderungsliste() {
		return aenderungsliste;
	}

	
	/* Getter- und Setter-Methoden */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	public void setAenderungsliste(ArrayList<Aenderung> aenderungsliste) {
		this.aenderungsliste = aenderungsliste;
	}
	
	
}
