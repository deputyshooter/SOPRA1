package projektelemente;

import java.util.Date;

import javax.persistence.*;
import javax.faces.bean.*;

import benutzer.Benutzer;

/**
 * Instanzen der Klasse Kommentar sind genau einer Beschreibung zugeordnet. Sie
 * sind durch die Attribute Text, Autor und einem Zeitstempel definiert.
 * 
 * @author Manuel Weber
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Kommentar {

	@Id
	private int id = 0;

	private String text;
	private Benutzer autor;
	@Temporal(TemporalType.DATE)
	private Date zeitstempel;
	@ManyToOne
	private Beschreibung beschreibung;

	/**
	 * 
	 */
	public void save() {
		EntityManager em = extern.Datenbank.getEntityManager();
		System.out.println("start save");
		Kommentar test = new Kommentar();
		try {
			em.getTransaction().begin();
			test.setId(0);
			test.setText("blablablabla");
			test.setAutor(null);
			test.setZeitstempel(null);
			test = em.merge(test);
			em.getTransaction().commit();
			System.out.println("test saved");
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	
	/* Getter- und Setter-Methoden */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Benutzer getAutor() {
		return autor;
	}

	public void setAutor(Benutzer autor) {
		this.autor = autor;
	}

	public Date getZeitstempel() {
		return zeitstempel;
	}

	public void setZeitstempel(Date zeitstempel) {
		this.zeitstempel = zeitstempel;
	}

	public Beschreibung getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(Beschreibung beschreibung) {
		this.beschreibung = beschreibung;
	}

}
