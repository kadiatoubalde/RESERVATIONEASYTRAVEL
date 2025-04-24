package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Passager  extends  AbstractDomainClass{
    private  String  nom;
    private  String  prenom;
    private  String   adresse;
    private  String  telephone;
    private  String  telephonePersonneContact;
    private  String  adressePersonneContact;
    private  String  civilite;
    private  String  genre;

    @OneToMany(mappedBy = "passager")
    private List<Reservation> reservations;

  

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephonePersonneContact() {
		return telephonePersonneContact;
	}

	public void setTelephonePersonneContact(String telephonePersonneContact) {
		this.telephonePersonneContact = telephonePersonneContact;
	}

	public String getAdressePersonneContact() {
		return adressePersonneContact;
	}

	public void setAdressePersonneContact(String adressePersonneContact) {
		this.adressePersonneContact = adressePersonneContact;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	

	public Passager() {
		super();
		
	}

	public Passager(String nom, String prenom, String adresse, String telephone, String telephonePersonneContact,
			String adressePersonneContact, String civilite, String genre, List<Reservation> reservations) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.telephonePersonneContact = telephonePersonneContact;
		this.adressePersonneContact = adressePersonneContact;
		this.civilite = civilite;
		this.genre = genre;
		this.reservations = reservations;
	}

	

}
