package org.reservation_backend.dto;

import java.util.List;


import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.PlanificationVoyageDto;



public class PassagerDto {
	    private String uuid;
	    private  String  nom;
	    private  String  prenom;
	    private  String   adresse;
	    private  String  telephone;
	    private  String  telephonePersonneContact;
	    private  String  adressePersonneContact;
	    private  String  civilite;
	    private  String  genre;
	    private List<ReservationDto> reservations;
	    private List<PlanificationVoyageDto>  voyages;
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
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
		public List<ReservationDto> getReservations() {
			return reservations;
		}
		public void setReservations(List<ReservationDto> reservations) {
			this.reservations = reservations;
		}
		public List<PlanificationVoyageDto> getVoyages() {
			return voyages;
		}
		public void setVoyages(List<PlanificationVoyageDto> voyages) {
			this.voyages = voyages;
		}
		public PassagerDto() {
			super();
			
		}
		
	    
	    
	

}
