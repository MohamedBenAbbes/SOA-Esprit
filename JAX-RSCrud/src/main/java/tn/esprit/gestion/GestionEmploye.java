package tn.esprit.gestion;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.entities.Employe;
import tn.esprit.entities.Secured;

@Path("/employe")
public class GestionEmploye {
	
	static List<Employe> employes = new ArrayList<Employe>();
	
	public GestionEmploye() {
		employes.add(new Employe("123456", "Atef", "Jlassi"));
	}
	
	@POST
	@Consumes("application/xml")
	public Response ajouterEmploye(Employe employe) {
		if (employes.add(employe)) {
			return Response.status(Status.CREATED).entity("add successful").build();
		}
		else
			return Response.status(Status.NO_CONTENT).entity("add failed").build();
	}
	
	@PUT
	@Consumes("application/xml")
	@Secured
	public String modifierEmploye(Employe employe) {
		int i=0;
		for(Employe employee: employes ) {
			if(employee.getCin().equals(employe.getCin())) {
				//employes.remove(i);
				employes.set(i, employe);
			}
			else {
				i++;	
			}
		}
		return "modifier avec succées";
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employe chercherEmploye(@PathParam("id") String cin ) {
		for (Employe employe : employes) {
			if(employe.getCin().equals(cin)) {
				return employe;
			}	
		}
		return null;
	}
	
	
	@Secured
	@GET
	@Produces("application/xml")
	public List<Employe> listEmployees() {
		if(employes==null)
			return null;
		return  employes;
		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") String cin) {
		int i=0;
		for(Employe employee: employes ) {
			if(employee.getCin().equals(cin)) {
				employes.remove(i);
				//employes.set(i, employe);
				//Response.status(Status.CREATED).entity("delete successful").build();	
				return "suppression fait";
				}
				else {
					i++;	
				}
			}
		return "pas de suppression";
		
		//return Response.status(Status.NO_CONTENT).entity("delete failed").build();
		
	}
	
	/*
	public int getIndexBycin(String cin) {
		for(Employe emp: employes) {
			if(emp.getCin().equals(cin))
				return employes.indexOf(emp);
		}
		return -1;
	}
	*/
}
