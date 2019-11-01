package esprit;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshelling {

	public static void main(String [] o) {
		try {
			
			//creating the JAXB context
			JAXBContext jContext = JAXBContext.newInstance(Personne.class);
			//creating the marshaller object
			Marshaller marshallObj = jContext.createMarshaller();
			//setting the property to show xml format output
			marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//setting the values in POJO class
			Personne pers1 = new Personne(123, "Jlassi", "Atef", 2225558);
			//calling the marshall method
			marshallObj.marshal(pers1, new FileOutputStream("personne.xml"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
