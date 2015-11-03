/**
 * 
 */
package fr.lavoie.france.service;

import javax.ws.rs.core.Response;

import fr.lavoie.france.model.Disciple;

/**
 * @author chrmampu
 *
 */
public interface IDiscipleService {

	public Response getAllDisciples();
	public Response getDiscipleByMail(String mail);
	public void createDisciple(Disciple disciple);
	public void editDisciple(Disciple disciple);
	public void deleteDisciple(Disciple disciple);
}
