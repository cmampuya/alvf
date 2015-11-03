/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Rameau;
import fr.lavoie.france.model.Secteur;
import fr.lavoie.france.service.AdresseServiceImpl;
import fr.lavoie.france.utils.HibernateUtil;

/**
 * @author chrmampu
 *
 */
public class RameauDaoImpl implements IRameauDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	
	@Override
	public List<Rameau> getAllRameaux() {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Rameau> listRameau = new ArrayList<Rameau>();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		listRameau = (List<Rameau>) session.createQuery("from Rameau");
		
		session.getTransaction().commit();
		
		return listRameau;
	}

	@Override
	public Rameau getSecteurByReponsable(Long id) {
		
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Rameau rameau = new Rameau();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		rameau = (Rameau) session.createQuery("from Rameau r, Disciple d where r.id = d.rameau and d.id = :id")
				.setParameter("id", id);
		
		session.getTransaction().commit();
		
		return rameau;
	}

	@Override
	public void createRameau(Rameau rameau) {
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Long id = (Long) adresseServiceImpl.createAdresse(rameau.getAdresses());
		rameau.setSiege(id);
		session.save(rameau);
		
		session.getTransaction().commit();

	}

	@Override
	public void editRameau(Rameau rameau) {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		session.update(rameau);
		
		session.getTransaction().commit();

	}

	@Override
	public void deleteRameau(Rameau rameau) {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		session.delete(rameau);
		
		session.getTransaction().commit();

	}

}
