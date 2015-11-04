package fr.lavoie.france.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory sessionfactory;
	
	static {
		try{
			Configuration cfg = new Configuration().addResource("hibernate.cfg.xml");
			sessionfactory = cfg.configure().buildSessionFactory();
			
		}catch (Throwable ex){
			System.err.println("Initialisation de la sessionFactory a echoue" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionfactory;
	}
}
