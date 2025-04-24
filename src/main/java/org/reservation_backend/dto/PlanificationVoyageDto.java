package org.reservation_backend.dto;

import java.time.LocalDate;

public class PlanificationVoyageDto {
	private String uuid;
    private LocalDate heureDepart;
    private  LocalDate heureArrivee;
    private int nombrePlaces;
    private int nombrePlacesImage;
    private double montant;
    private String uuidTrajet;
    private String uuidVehicule;
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
	public PlanificationVoyageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanificationVoyageDto(String uuid, LocalDate heureDepart, LocalDate heureArrivee, int nombrePlaces,
			int nombrePlacesImage, double montant, String uuidTrajet, String uuidVehicule, String uuidUtilisateur) {
		super();
		this.uuid = uuid;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.nombrePlaces = nombrePlaces;
		this.nombrePlacesImage = nombrePlacesImage;
		this.montant = montant;
		this.uuidTrajet = uuidTrajet;
		this.uuidVehicule = uuidVehicule;
		this.uuidUtilisateur = uuidUtilisateur;
	}
	
    
    

}
