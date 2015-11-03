/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.List;

import fr.lavoie.france.model.Rameau;

/**
 * @author chrmampu
 *
 */
public interface IRameauDao {

	public List<Rameau> getAllRameaux();
	public Rameau getSecteurByReponsable(Long id);
	public void createRameau(Rameau rameau);
	public void editRameau(Rameau rameau);
	public void deleteRameau(Rameau rameau);
}
