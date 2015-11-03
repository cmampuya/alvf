/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Secteur;
import fr.lavoie.france.service.AdresseServiceImpl;
import fr.lavoie.france.utils.HibernateUtil;

/**
 * @author chrmampu
 *
 */
public class SecteurDaoImpl implements ISecteurDao {

	HibernateUtil hibernateutil = new HibernateUtil();
	
	
	@Override
	public List<Secteur> getAllSecteurs() {
		
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Secteur> listSecteur = new ArrayList<Secteur>();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		listSecteur = (List<Secteur>) session.createQuery("from Secteur");
		
		session.getTransaction().commit();
		
		return listSecteur;
		
	}


	@Override
	public void createSecteur(Secteur secteur) {
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();

		Long id = (Long) adresseServiceImpl.createAdresse(secteur.getAdresses());
		secteur.setSiege(id);
		session.save(secteur);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void editSecteur(Secteur secteur) {
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();
		
		session.update(secteur);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteSecteur(Secteur secteur) {
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();
		
		session.delete(secteur);
		
		session.getTransaction().commit();
		
	}


	@Override
	public Secteur getSecteurByReponsable(Long id) {
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Secteur secteur = new Secteur();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		secteur = (Secteur) session.createQuery("from Secteur s, Disciple d where s.id = d.secteur and d.id = :id")
				.setParameter("id", id);
		
		session.getTransaction().commit();
		
		return secteur;
	}

	
}
