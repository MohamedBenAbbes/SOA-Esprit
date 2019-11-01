package tn.esprit.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employe {

	private String cin;
	private String nom;
	private String prenom;

	public Employe() {
	}

	public Employe(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}

	@XmlAttribute(name = "id", required = true)
	public String getCin() {
		return cin;
	}

	@XmlElement(name = "LastName", required = true)
	public String getNom() {
		return nom;
	}

	@XmlElement(name = "FirstName")
	public String getPrenom() {
		return prenom;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		return true;
	}

	/*********************************************/

}
