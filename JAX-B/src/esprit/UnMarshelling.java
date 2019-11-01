package esprit;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UnMarshelling {

	public static void main(String [] args) {
		try {
			
			
			//getting the xml file to read
			File file=new File("personne.xml");
			//creating the JAXB context
			JAXBContext jContext = JAXBContext.newInstance(Personne.class);
			//creating the marshaller object
            Unmarshaller  unmarshallObj = jContext.createUnmarshaller();
			//calling the unmarshall method
            Personne personne=(Personne)unmarshallObj.unmarshal(file);
			//calling the marshall method
			System.out.println(personne);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
