package fr.lavoie.france.test;

import java.util.Date;

import org.hibernate.SessionFactory;

import fr.lavoie.france.model.Adresse;
import fr.lavoie.france.model.Disciple;
import fr.lavoie.france.service.DiscipleServiceImpl;
import fr.lavoie.france.utils.HibernateUtil;

public class TestApplication {

	public static void main(String[] args) {
		
		HibernateUtil hibernate = new HibernateUtil();
		SessionFactory sessionfactory = hibernate.getSessionFactory();
		DiscipleServiceImpl service = new DiscipleServiceImpl();
		
		Disciple disciple = new Disciple();
		disciple.setFirstname("firstname1");
		disciple.setLastname("lastname1");
		disciple.setPhone(9076876);
		disciple.setBirthday(new Date());
		disciple.setCreatedon(new Date());
		disciple.setSecteur((long)1);
		disciple.setRameau((long)1);
		disciple.setCommunion((long)1);
		disciple.setFonction("Coord1");
		disciple.setMail("lastname6@test.fr");
		disciple.setStatut("true");
		disciple.setEtat_civil("Celibateur");
		
		Adresse adresse = new Adresse();
		adresse.setNumero((long) 21);
		adresse.setComplement("residence de la foie");
		adresse.setCp(32456);
		adresse.setRue("Avenue de la force");
		adresse.setPays("France");
		adresse.setVille("VSG");
		
		disciple.setAdresses(adresse);
		service.createDisciple(disciple);
	   
	  }
}
