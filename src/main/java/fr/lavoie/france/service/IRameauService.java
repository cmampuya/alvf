/**
 * 
 */
package fr.lavoie.france.service;

import java.util.List;

import fr.lavoie.france.model.Rameau;

/**
 * @author chrmampu
 *
 */
public interface IRameauService {

	public List<Rameau> getAllRameaux();
	public Rameau getSecteurByReponsable(Long id);
	public void createRameau(Rameau rameau);
	public void editRameau(Rameau rameau);
	public void deleteRameau(Rameau rameau);
}
