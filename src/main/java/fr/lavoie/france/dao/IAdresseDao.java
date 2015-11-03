/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.List;

import fr.lavoie.france.model.Adresse;
import fr.lavoie.france.model.Secteur;

/**
 * @author chrmampu
 *
 */
public interface IAdresseDao {

	//public List<Adresse> getAllAdresse();
	//public Adresse getAdresseById(Long id);
	public Long createAdresse(Adresse adresse);
	//public void editAdresse(Adresse adresse);
	//public void deleteAdresse(Adresse adresse);
}
