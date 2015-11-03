/**
 * 
 */
package fr.lavoie.france.dao;

import java.util.List;

import fr.lavoie.france.model.Disciple;

/**
 * @author chrmampu
 *
 */
public interface IDiscipleDao {

	/**
	 * 
	 * @return
	 */
	public List<Disciple> getAllDisciples();
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	public Disciple getDiscipleByMail(String mail);
	
	/**
	 * 
	 * @param disciple
	 */
	public void createDisciple(Disciple disciple);
	
	/**
	 * 
	 * @param disciple
	 */
	public void editDisciple(Disciple disciple);
	
	/**
	 * 
	 * @param disciple
	 */
	public void deleteDisciple(Disciple disciple);

}
