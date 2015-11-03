/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Adresse;
import fr.lavoie.france.utils.HibernateUtil;

/**
 * @author chrmampu
 *
 */
public class AdresseDaoImpl implements IAdresseDao {
	HibernateUtil hibernateutil = new HibernateUtil();
	
	@Override
	public Long createAdresse(Adresse adresse) {
		
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();
		
		Long id = (Long) session.save(adresse);
		
		session.getTransaction().commit();
		
		return id;
	}

	
}
