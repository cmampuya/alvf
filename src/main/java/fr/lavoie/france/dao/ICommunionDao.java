/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.List;

import fr.lavoie.france.model.Communion;
import fr.lavoie.france.model.Rameau;

/**
 * @author chrmampu
 *
 */
public interface ICommunionDao {
	public List<Communion> getAllCommunions();
	public Communion getCommunionByReponsable(Long id);
	public void createCommunion(Communion communion);
	public void editCommunion(Communion communion);
	public void deleteCommunion(Communion communion);
}
