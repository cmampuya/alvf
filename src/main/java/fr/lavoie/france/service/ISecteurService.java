/**
 * 
 */
package fr.lavoie.france.service;

import java.util.List;

import fr.lavoie.france.model.Secteur;

/**
 * @author chrmampu
 *
 */
public interface ISecteurService {

	public List<Secteur> getAllSecteurs();
	public Secteur getSecteurByReponsable(Long id);
	public void createSecteur(Secteur secteur);
	public void editSecteur(Secteur secteur);
	public void deleteSecteur(Secteur secteur);
}
