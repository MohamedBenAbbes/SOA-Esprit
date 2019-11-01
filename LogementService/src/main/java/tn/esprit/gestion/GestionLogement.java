package tn.esprit.gestion;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Query;

import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.RendezVous;

@Path("/logements")
public class GestionLogement {

	static List<RendezVous> listRendezvous=new ArrayList<RendezVous>();
	
	LogementBusiness logeBusiness = new LogementBusiness();
	
	public GestionLogement() {
		// TODO Auto-generated constructor stub
	}

	
	@GET
	@Produces("application/json")
	public Response getAllLogements() {
		if(logeBusiness.getLogements() == null) 
			return Response.status(Response.Status.NOT_FOUND).build();
		
		if(logeBusiness.getLogements().size() == 0)
			return Response.status(Response.Status.BAD_REQUEST).entity("Pas de contenu").build();
		else
			return Response.ok(logeBusiness.getLogements(), MediaType.APPLICATION_JSON).build();
		
	}
	
	@GET
	@Produces("application/json")
	public Response getLogementById() {
		return null;
	}
	
}
