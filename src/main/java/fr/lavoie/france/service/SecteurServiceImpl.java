/**
 * 
 */
package fr.lavoie.france.service;

import java.util.List;

import fr.lavoie.france.dao.SecteurDaoImpl;
import fr.lavoie.france.model.Secteur;

/**
 * @author chrmampu
 *
 */
public class SecteurServiceImpl implements ISecteurService {

	
	SecteurDaoImpl secteurDaoImpl = new SecteurDaoImpl();
	
	@Override
	public List<Secteur> getAllSecteurs() {
		return secteurDaoImpl.getAllSecteurs();
	}


	@Override
	public Secteur getSecteurByReponsable(Long id) {
		return secteurDaoImpl.getSecteurByReponsable(id);
	}

	@Override
	public void createSecteur(Secteur secteur) {
		secteurDaoImpl.createSecteur(secteur);
	}


	@Override
	public void editSecteur(Secteur secteur) {
		secteurDaoImpl.editSecteur(secteur);
	}

	@Override
	public void deleteSecteur(Secteur secteur) {
		secteurDaoImpl.deleteSecteur(secteur);

	}

}
