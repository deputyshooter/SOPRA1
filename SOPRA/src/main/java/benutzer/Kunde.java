package benutzer;

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

	@OneToMany(mappedBy = "kunde")
	private Set<Projekt> projekte;
	
	public Kunde() {
		this.accountart = "Kunde";
	}

	/* Getter- und Setter-Methoden */
	
	public Set<Projekt> getProjekte() {
		return projekte;
	}

	public void setProjekte(Set<Projekt> projekte) {
		this.projekte = projekte;
	}
	
}
