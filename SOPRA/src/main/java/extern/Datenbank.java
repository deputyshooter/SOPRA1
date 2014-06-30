package extern;

import java.util.List;

import javax.persistence.*;

import benutzer.Administrator;
import benutzer.Analyst;
import benutzer.Benutzer;
import benutzer.Kunde;

/**
 * Ermöglicht Zugriffe auf die Datenbank
 * 
 * @author Manuel Weber
 */
public class Datenbank{
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOPRA");
	static EntityManager em = emf.createEntityManager();
	
	
	public static EntityManager getEntityManager() {
		return em;
	}
	

	/**
	 * Speichert ein Objekt in der Datenbank
	 */
	public static void save(Object obj) {
		System.out.println("saving Object");
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			System.out.println("Object saved");
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	
	/**
	 * @return Liste aller registrierten Benutzer
	 */
	@SuppressWarnings("unchecked")
	public static List<Benutzer> getBenutzer() {
		Query query = getEntityManager().createQuery("SELECT b FROM Administrator b");
		List<Benutzer> liste = query.getResultList();
		query = getEntityManager().createQuery("SELECT b FROM Analyst b");
		liste.addAll(query.getResultList());
		query = getEntityManager().createQuery("SELECT b FROM Kunde b");
		liste.addAll(query.getResultList());
		return liste;
	} 
	
	/**
	 * @return Liste aller registrierten Analysten
	 */
	@SuppressWarnings("unchecked")
	public static List<Analyst> getAnalysten() {
		Query query = getEntityManager().createQuery("SELECT a FROM Analyst a");
		return query.getResultList();
	}
	
	/**
	 * @return Liste aller registrierten Kunden
	 */
	@SuppressWarnings("unchecked")
	public static List<Kunde> getKunden() {
		Query query = getEntityManager().createQuery("SELECT k FROM Kunde k");
		return query.getResultList();
	}
	
	/**
	 * @return Liste aller registrierten Administratoren
	 */
	@SuppressWarnings("unchecked")
	public static List<Administrator> getAdministratoren() {
		Query query = getEntityManager().createQuery("SELECT a FROM Administartor a");
		return query.getResultList();
	}
	
}
