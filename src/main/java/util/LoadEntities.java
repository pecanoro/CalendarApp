package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.ComunidadAutonoma;
import model.Festivos;
import model.FestivosCCAA;
import model.FestivosNacionales;
import model.Localidad;
import model.Provincia;

public class LoadEntities {

	private static final String PERSISTENCE_UNIT = "calendar";

	private static EntityManagerFactory factory;

	public LoadEntities() {
	}
	
	/**
	 * Find a city with a given id
	 */
	public static Provincia findCityById(Integer id) {
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Provincia city = em.find(Provincia.class, id);
	    em.close();

	    return city;
	}
  
	/**
	 * Find a city with a given name
	 */
	@SuppressWarnings("rawtypes")
	public static Provincia findCityByName(String name) {
		    EntityManager em = factory.createEntityManager();
		    Query q = em.createQuery("SELECT x FROM Provincia x WHERE x.provincia = ?1");
			q.setParameter(1, name);
			List results = q.getResultList();
			
			Provincia city = null;
			if(!results.isEmpty()){
				// ignores multiple results
		        city = (Provincia) results.get(0);
		    }
	
		    return city;
	  }
	
	/**
	 * Find all the cities
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Provincia> findAllCities(ComunidadAutonoma id) {
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("SELECT x FROM Provincia x WHERE x.idComunidadAutonoma = ?1 ORDER BY x.provincia");
	    q.setParameter(1, id);
	    List results = q.getResultList();

	    return (List<Provincia>) results;
	}
	
	/**
	 * Find a Community with a given id
	 */
	public static ComunidadAutonoma findCommunityById(Integer id) {
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    ComunidadAutonoma city = em.find(ComunidadAutonoma.class, id);
	    em.close();

	    return city;
	}
  
	/**
	 * Find a Community with a given name
	 */
	@SuppressWarnings("rawtypes")
	public static ComunidadAutonoma findCommunityByName(String name) {
		    EntityManager em = factory.createEntityManager();
		    Query q = em.createQuery("SELECT x FROM ComunidadAutonoma x WHERE x.comunidadAutonoma = ?1");
			q.setParameter(1, name);
			List results = q.getResultList();
			
			ComunidadAutonoma city = null;
			if(!results.isEmpty()){
				// ignores multiple results
		        city = (ComunidadAutonoma) results.get(0);
		    }
				
		    return city;
	  }
	
	/**
	 * Find a Community with a given name
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<ComunidadAutonoma> findAllCommunities() {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM ComunidadAutonoma x ORDER BY x.comunidadAutonoma");
			List results = q.getResultList();
						
			List<ComunidadAutonoma> res = new LinkedList<ComunidadAutonoma>();
			res.addAll(results);
	
		    return res;
	  }
	
	/**
	 * Find a Municipality with a given id
	 */
	public static Localidad findMunicipalityById(Integer id) {
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Localidad city = em.find(Localidad.class, id);
	    em.close();

	    return city;
	}
  
	/**
	 * Find a Municipality with a given name
	 */
	@SuppressWarnings("rawtypes")
	public static Localidad findMunicipalityByName(String name) {
		    EntityManager em = factory.createEntityManager();
		    Query q = em.createQuery("SELECT x FROM Localidad x WHERE x.localidad = ?1 ORDER BY x.localidad");
			q.setParameter(1, name);
			List results = q.getResultList();
			
			Localidad city = null;
			if(!results.isEmpty()){
				// ignores multiple results
		        city = (Localidad) results.get(0);
		    }
				
		    return city;
	  }
	
	/**
	 * Find all Municipalities
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Localidad> findAllMunicipalities() {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Localidad x ORDER BY x.localidad");
			List results = q.getResultList();
				
		    return (List<Localidad>) results;
	  }
	
	/**
	 * Find a Municipality with a given name
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Localidad> findAllMunicipalities(Provincia id) {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Localidad x WHERE x.idProvincia = ?1 ORDER BY x.localidad");
		    q.setParameter(1, id);
			List results = q.getResultList();
				
		    return (List<Localidad>) results;
	  }

	/**
	 * Find a Holiday with a given id
	 */
	public static Festivos findHolidayById(Integer id) {
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Festivos city = em.find(Festivos.class, id);
	    em.close();

	    return city;
	}
  
	/**
	 * Find all the holidays given a Community, a City and a Municipality
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Festivos> findHolidayByPlace(ComunidadAutonoma ca, Provincia c, Localidad m) {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Festivos x WHERE x.idComunidadAutonoma = ?1 AND x.idProvincia = ?2 AND x.idLocalidad = ?3");
		    
			q.setParameter(1, ca);
			q.setParameter(2, c);
			q.setParameter(3, m);
			List results = q.getResultList();
						
			List<Festivos> res = new ArrayList<Festivos>();
			res.addAll(results);
			
		    return res;
	  }
	
	/**
	 * Find CCAA holidays
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<FestivosCCAA> findHolidayCCAA(ComunidadAutonoma ca) {
		EntityManager em = factory.createEntityManager();
	    
	    Query q = em.createQuery("SELECT x FROM FestivosCCAA x WHERE x.idComunidadAutonoma = ?1");
	    q.setParameter(1, ca);
		List results = q.getResultList();
					
		List<FestivosCCAA> res = new ArrayList<FestivosCCAA>();
		res.addAll(results);
		
	    return res;
	}
	
	/**
	 * Find national holidays
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<FestivosNacionales> findHolidayNational() {
		EntityManager em = factory.createEntityManager();
	    
	    Query q = em.createQuery("SELECT x FROM FestivosNacionales x");
	    
		List results = q.getResultList();
					
		List<FestivosNacionales> res = new ArrayList<FestivosNacionales>();
		res.addAll(results);
		
	    return res;
	}
	
	/**
	 * Check if a date is a holiday
	 */
	@SuppressWarnings("rawtypes")
	public static Boolean checkHoliday(ComunidadAutonoma ca, Provincia c, Localidad m, Date d) {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Festivos x WHERE x.idComunidadAutonoma = ?1 AND x.idProvincia = ?2 AND x.idLocalidad = ?3 AND x.festivo = ?4");
			q.setParameter(1, ca);
			q.setParameter(2, c);
			q.setParameter(3, m);
			q.setParameter(4, d);
			List results = q.getResultList();
						
		    return !results.isEmpty();
	  }
	
	/**
	 * Find all the holidays between two given dates
	 */
	@SuppressWarnings({"unchecked", "deprecation" })
	public static List<Festivos> findHolidayBetweenJud(ComunidadAutonoma ca, Provincia c, Localidad m, Date d1, Date d2) {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Festivos x WHERE x.idComunidadAutonoma = ?1 AND x.idProvincia = ?2 AND x.idLocalidad = ?3 AND x.festivo >= ?4 AND x.festivo <= ?5");
		    
			q.setParameter(1, ca);
			q.setParameter(2, c);
			q.setParameter(3, m);
			q.setParameter(4, d1);
			q.setParameter(5, d2);
			List<Festivos> results = (List<Festivos>) q.getResultList();
						
			List<Festivos> res = new ArrayList<Festivos>();
			for(Festivos f : results){
				if(f.getFestivo().getDay()!=0 && f.getFestivo().getDay()!=6){
					res.add(f);
				}
			}
			
		    return res;
	  }
	
	/**
	 * Find all the holidays between two given dates
	 */
	@SuppressWarnings({"unchecked", "deprecation" })
	public static List<Festivos> findHolidayBetweenAdmin(ComunidadAutonoma ca, Provincia c, Localidad m, Date d1, Date d2) {
		    EntityManager em = factory.createEntityManager();
		    
		    Query q = em.createQuery("SELECT x FROM Festivos x WHERE x.idComunidadAutonoma = ?1 AND x.idProvincia = ?2 AND x.idLocalidad = ?3 AND x.festivo >= ?4 AND x.festivo <= ?5");
		    
			q.setParameter(1, ca);
			q.setParameter(2, c);
			q.setParameter(3, m);
			q.setParameter(4, d1);
			q.setParameter(5, d2);
			List<Festivos> results = (List<Festivos>) q.getResultList();
						
			List<Festivos> res = new ArrayList<Festivos>();
			for(Festivos f : results){
				if(f.getFestivo().getDay()!=0){
					res.add(f);
				}
			}
			
		    return res;
	  }
	
	
	public static void createFactory() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	public static void closeFactory() {
		factory.close();
	}

	protected EntityManagerFactory getFactory() {
		return factory;
	}


}
