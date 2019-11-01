package rest.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloResourceClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();

		/****************************/

		WebTarget target6 = client.target("http://localhost:8080/Hello_JAX_RS-1.0-SNAPSHOT/rest/greetings");
		WebTarget helloTo1 = target6.path("foulen").path("ben foulen");
		Response response1 = helloTo1.request().get();
		String result1 = response1.readEntity(String.class);
		System.out.println(result1);
		response1.close();
	
		
		/****************************/
		
		WebTarget target = client.target("http://localhost:8080/Hello_JAX_RS-1.0-SNAPSHOT/rest/greetings/aymen/jlassi");
		Response response = target.request().get();
		String result = response.readEntity(String.class);
		System.out.println(result);
		response.close();
		
		/****************************/
		WebTarget target3 = client.target("http://localhost:8080/Hello_JAX_RS-1.0-SNAPSHOT/rest/greetings?");
		WebTarget hello3 = target3.queryParam("FirstName", "Atef").queryParam("LastName", "Jlassi");
		Response response2=hello3.request().get();
		String result2=response2.readEntity(String.class);
		System.out.println(result2);
		response2.close();
		
		

	}

}
