package org.reservation_backend.dto;

import jakarta.annotation.Nonnull;
import lombok.NonNull;

import java.time.LocalDate;

public class PlanificationVoyageDto {
	private String uuid;
	@NonNull
	private LocalDate heureDepart;
	@NonNull
	private  LocalDate heureArrivee;
	@NonNull
	private int nombrePlaces;
	@NonNull
	private int nombrePlacesImage;
	@NonNull
	private double montant;
	@NonNull
	private String uuidTrajet;
	@NonNull
	private String uuidVehicule;
	@NonNull
	private String uuidUtilisateur;
    
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public LocalDate getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(LocalDate heureDepart) {
		this.heureDepart = heureDepart;
	}
	public LocalDate getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(LocalDate heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public int getNombrePlacesImage() {
		return nombrePlacesImage;
	}
	public void setNombrePlacesImage(int nombrePlacesImage) {
		this.nombrePlacesImage = nombrePlacesImage;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getUuidTrajet() {
		return uuidTrajet;
	}
	public void setUuidTrajet(String uuidTrajet) {
		this.uuidTrajet = uuidTrajet;
	}
	public String getUuidVehicule() {
		return uuidVehicule;
	}
	public void setUuidVehicule(String uuidVehicule) {
		this.uuidVehicule = uuidVehicule;
	}
	public String getUuidUtilisateur() {
		return uuidUtilisateur;
	}
	public void setUuidUtilisateur(String uuidUtilisateur) {
		this.uuidUtilisateur = uuidUtilisateur;
	}

	
    
    

}
