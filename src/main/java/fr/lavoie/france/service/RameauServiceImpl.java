/**
 * 
 */
package fr.lavoie.france.service;

import java.util.List;

import fr.lavoie.france.dao.RameauDaoImpl;
import fr.lavoie.france.model.Rameau;

/**
 * @author chrmampu
 *
 */
public class RameauServiceImpl implements IRameauService {

	RameauDaoImpl rameauDaoImpl = new RameauDaoImpl();
	
	@Override
	public List<Rameau> getAllRameaux() {
		return rameauDaoImpl.getAllRameaux();
	}

	@Override
	public Rameau getSecteurByReponsable(Long id) {
		return rameauDaoImpl.getSecteurByReponsable(id);
	}

	@Override
	public void createRameau(Rameau rameau) {
		rameauDaoImpl.createRameau(rameau);
	}

	@Override
	public void editRameau(Rameau rameau) {
		rameauDaoImpl.editRameau(rameau);
	}

	@Override
	public void deleteRameau(Rameau rameau) {
		rameauDaoImpl.deleteRameau(rameau);
	}

}
