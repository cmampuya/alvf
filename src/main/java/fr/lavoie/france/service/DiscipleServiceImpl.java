/**
 * 
 */
package fr.lavoie.france.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import fr.lavoie.france.dao.DiscipleDaoImpl;
import fr.lavoie.france.model.Disciple;

/**
 * @author chrmampu
 *
 */
@Path("/disciples")
public class DiscipleServiceImpl implements IDiscipleService {

	
	/*@Inject*/DiscipleDaoImpl discipledao = new DiscipleDaoImpl();
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAllDisciples() {
		List<Disciple> listDisciple = discipledao.getAllDisciples();
		return Response.ok().entity(new GenericEntity<List<Disciple>>(listDisciple){})
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods","GET,POST,DELETE,PUT,OPTION,HEAD")
				.build();
	}


	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{mail}")
	public Response getDiscipleByMail(@PathParam("mail") String mail){ 
		Disciple disciple = discipledao.getDiscipleByMail(mail);
		return Response.ok().entity(new GenericEntity<Disciple>(disciple){})
				.header("Access-Control-Allow-Origin","*")
				.header("Access-Control-Allow-Methods","GET,POST,DELETE,PUT,OPTION,HEAD")
				.header("Access-Control-Max-Age", "3600")
				.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept")
				.build();
	}

	@Override
	public void createDisciple(Disciple disciple) {
		discipledao.createDisciple(disciple);
		
	}

	@Override
	public void editDisciple(Disciple disciple) {
		discipledao.editDisciple(disciple);
		
	}

	@Override
	public void deleteDisciple(Disciple disciple) {
		discipledao.deleteDisciple(disciple);
		
	}

}
