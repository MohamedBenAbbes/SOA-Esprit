package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("greetings")						//chemin de resource
public class Resource {
	@GET								//lecture de la resource via HTTP
	@Path("{FirstName}/{LastName}")		//recupere les argument passe dans la parametere
	@Produces(MediaType.TEXT_PLAIN)		//type de representation retournee par la requette GET
	public String sayHello(@PathParam(value="FirstName") String prenom,
							@PathParam(value="LastName") String nom) {
		return "hello " + prenom + " " + nom;
	}
}
