package fr.lavoie.france.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sun.org.apache.xml.internal.security.Init;

import fr.lavoie.france.model.Disciple;

public class Connect {

	private static Connection instance;
	private static DBConfiguration dbConfiguration;
	
	
	private Connect(){
		if(instance == null){
			instance = null ;
		}
		
	}
	
	public static  Connection getConnection(){
		InitialisationApp init = new InitialisationApp();
		dbConfiguration = init.loadParams();
		
		if(instance==null){
			try {
		    	
			      Class.forName(dbConfiguration.getDriver());
			      System.out.println(dbConfiguration.getDriver() + "Driver reussit.");
			      
			      String url = dbConfiguration.getUrl()+""+dbConfiguration.getServer()+":"+dbConfiguration.getPort()+"/"+dbConfiguration.getDbName();//jdbc:mysql://localhost:3306/min_la_voie";
			      String user = dbConfiguration.getUser(); //"root";
			      String passwd = dbConfiguration.getPassword(); //"";

			      instance = DriverManager.getConnection(url, user, passwd);
			        		         
			    } catch (Exception e) {
			    	System.out.println("Where is your mysql JDBC Driver? "
							+ "Include in your library path!");
			      e.printStackTrace();
			    }
		    
		      return instance;
		}else{
			return instance;
		}
		
	    
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		HibernateUtil hibernate = new HibernateUtil();
		SessionFactory sessionfactory = hibernate.getSessionFactory();
		
		Session session = sessionfactory.openSession();
		session.getTransaction().begin();
		List<Disciple> list = new ArrayList<Disciple>();
		//Disciple disciple = (Disciple) session.load(Disciple.class, new Integer(1));
		//System.out.println("Le nom est "+disciple.getFirstname());
		Criteria cr =session.createCriteria(Disciple.class);
		//cr.add(Restrictions.like("matricule", matricule));
		list = (List<Disciple>)session.createQuery("from Disciple").list();
				//.setParameter("matricule", matricule).uniqueResult();
		list = cr.list();
		System.out.println(list.get(0).getLastname());
		System.out.println(session.isOpen());
		System.out.println(session.isOpen());
		session.getTransaction().commit();
	    /*try {

	      Connection conn = getConnection();
	      
	    //Cr�ation d'un objet Statement
	      Statement state = conn.createStatement();
	      //L'objet ResultSet contient le r�sultat de la requ�te SQL
	      ResultSet result = state.executeQuery("SELECT * FROM disciples");
	      //On r�cup�re les MetaData
	      ResultSetMetaData resultMeta = result.getMetaData();
	         
	      System.out.println("\n**********************************");
	      //On affiche le nom des colonnes
	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	         
	      System.out.println("\n**********************************");
	         
	      while(result.next()){         
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.print("\t" + result.getObject(i).toString() + "\t |");
	            
	        System.out.println("\n---------------------------------");

	      }

	      result.close();
	      state.close();
	      
	      System.out.println("Connexion effective !");         
	         
	    } catch (Exception e) {
	      e.printStackTrace();
	    }      */
	  }
}
