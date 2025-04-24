package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Utilisateur  extends AbstractDomainClass{
    private String prenom;
    private  String nom;
    private  String telephone;
    private  String  adresse;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Utilisateur() {
		super();
	}
	public Utilisateur(String prenom, String nom, String telephone, String adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
	}
    
    

  
}
