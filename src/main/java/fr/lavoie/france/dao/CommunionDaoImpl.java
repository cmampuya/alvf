/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Communion;
import fr.lavoie.france.model.Secteur;
import fr.lavoie.france.service.AdresseServiceImpl;
import fr.lavoie.france.utils.HibernateUtil;

/**
 * @author chrmampu
 *
 */
public class CommunionDaoImpl implements ICommunionDao {

	HibernateUtil hibernateUtil = new HibernateUtil();	
	
	@Override
	public List<Communion> getAllCommunions() {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Communion> listCommunion = new ArrayList<Communion>();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		listCommunion = (List<Communion>) session.createQuery("from Communion");
		
		session.getTransaction().commit();
		
		return listCommunion;
	}

	/* (non-Javadoc)
	 * @see fr.lavoie.france.dao.ICommunionDao#getCommunionByReponsable(java.lang.Long)
	 */
	@Override
	public Communion getCommunionByReponsable(Long id) {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Communion communion = new Communion();
		
		session.getTransaction().begin();
		
		Criteria cr = session.createCriteria(Secteur.class);
		communion = (Communion) session.createQuery("from Communion c, Disciple d where c.id = d.rameau and d.id = :id")
				.setParameter("id", id);
		
		session.getTransaction().commit();
		
		return communion;
	}

	@Override
	public void createCommunion(Communion communion) {
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Long id = (Long) adresseServiceImpl.createAdresse(communion.getAdresses());
		communion.setSiege(id);
		session.save(communion);
		
		session.getTransaction().commit();

	}

	@Override
	public void editCommunion(Communion communion) {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		session.update(communion);
		
		session.getTransaction().commit();

	}

	@Override
	public void deleteCommunion(Communion communion) {
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		session.delete(communion);
		
		session.getTransaction().commit();

	}

}
