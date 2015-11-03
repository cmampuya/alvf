/**
 * 
 */
package fr.lavoie.france.test;

import java.util.Date;

import fr.lavoie.france.model.Adresse;
import fr.lavoie.france.model.Secteur;
import fr.lavoie.france.service.AdresseServiceImpl;
import fr.lavoie.france.service.SecteurServiceImpl;

/**
 * @author chrmampu
 *
 */
public class TestSecteur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Secteur secteur = new Secteur();
		Adresse adresse = new Adresse();
		SecteurServiceImpl secteurServiceImpl = new SecteurServiceImpl();
		AdresseServiceImpl adresseServiceImpl = new AdresseServiceImpl();
		
		adresse.setNumero((long) 21);
		adresse.setComplement("residence de la foie");
		adresse.setCp(32456);
		adresse.setRue("Avenue de la force");
		adresse.setPays("France");
		adresse.setVille("VSG");
		
		secteur.setNom("Secteur Sud");
		secteur.setCoordonnateur((long)1);
		secteur.setAssistant((long)1);
		secteur.setAdresses(adresse);
		secteur.setCreatedon(new Date());
		secteurServiceImpl.createSecteur(secteur);
	}

}
