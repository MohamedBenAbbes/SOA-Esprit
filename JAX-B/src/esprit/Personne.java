package esprit;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "personne")
@XmlType(propOrder = {"prenom", "nom"})

public class Personne {

	
	private int cin;
	private String nom;
	private String prenom;
	private int numTel;
	
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Personne(int cin, String nom, String prenom, int numTel) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
	}


	@XmlAttribute
	public int getCin() {
		return cin;
	}
	
	@XmlElement
	public String getNom() {
		return nom;
	}
	
	@XmlElement
	public String getPrenom() {
		return prenom;
	}
	
	//@XmlElement
	@XmlTransient
	public int getNumTel() {
		return numTel;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}



	@Override
	public String toString() {
		return "Personne [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + "]";
	}
	
	
}
