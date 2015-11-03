/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Disciple;
import fr.lavoie.france.service.AdresseServiceImpl;
import fr.lavoie.france.utils.HibernateUtil;

/**
 * @author chrmampu
 *
 */
public class DiscipleDaoImpl implements IDiscipleDao {

	HibernateUtil hibernateutil = new HibernateUtil();

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciple> getAllDisciples() {
		
		@SuppressWarnings("static-access")
		SessionFactory sessionfactory = hibernateutil.getSessionFactory();
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		List<Disciple> list = new ArrayList<Disciple>();
		//Disciple disciple = (Disciple) session.load(Disciple.class, new Integer(1));
		//System.out.println("Le nom est "+disciple.getFirstname());
		Criteria cr =session.createCriteria(Disciple.class);
		list = (List<Disciple>)session.createQuery("from Disciple").list();
		list = cr.list();
				
		return list;
	}

	@Override
	public Disciple getDiscipleByMail(String mail) {

		SessionFactory sessionfactory = hibernateutil.getSessionFactory();
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		Disciple disciple = new Disciple();

		Criteria cr =session.createCriteria(Disciple.class);
		
		disciple = (Disciple)session.createQuery("from Disciple d where d.mail = :mail")
				.setParameter("mail", mail).uniqueResult();
		
		return disciple;
	}

	@Override
	public void createDisciple(Disciple disciple) {
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		
		if(EmailValidator.getInstance().isValid(disciple.getMail())){
			@SuppressWarnings("static-access")
			SessionFactory sessionFactory = hibernateutil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			Long id = (Long) adresseServiceImpl.createAdresse(disciple.getAdresses());
			disciple.setAdresse(id);
			session.save(disciple);
			System.out.println("L'identifiant est : " + id);
			session.getTransaction().commit();
		}else
			System.out.println("Adresse mail non valide");
	}

	@Override
	public void editDisciple(Disciple disciple) {
		
		if(EmailValidator.getInstance().isValid(disciple.getMail())){
			SessionFactory sessionFactory = hibernateutil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.update(disciple);
			session.getTransaction().commit();
		}else
			System.out.println("Adresse mail non valide");
	}

	@Override
	public void deleteDisciple(Disciple disciple) {
		
		SessionFactory sessionFactory = hibernateutil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(disciple);
		session.getTransaction().commit();
	}


}
