/**
 * 
 */
package fr.lavoie.france.service;

import fr.lavoie.france.dao.AdresseDaoImpl;
import fr.lavoie.france.model.Adresse;

/**
 * @author chrmampu
 *
 */
public class AdresseServiceImpl implements IAdresseService {

	
	AdresseDaoImpl adresseDaoImpl = new AdresseDaoImpl();
	
	@Override
	public Long createAdresse(Adresse adresse) {
		return adresseDaoImpl.createAdresse(adresse);
	}

}
