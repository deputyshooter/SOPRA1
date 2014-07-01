package benutzer;

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import projektelemente.Projekt;


/**
 * 
 * 
 */
@Entity
@ManagedBean
@ApplicationScoped
public class Kunde extends Benutzer {

	private static final long serialVersionUID = 6402234998131369691L;

	@OneToMany(mappedBy = "kunde")
	private Set<Projekt> projekte;
	
	public Kunde() {
		this.accountart = "Kunde";
		this.projekte = new HashSet<Projekt>();
	}

	/* Getter- und Setter-Methoden */
	
	public Set<Projekt> getProjekte() {
		return projekte;
	}

	public void setProjekte(Set<Projekt> projekte) {
		this.projekte = projekte;
	}
	
}
