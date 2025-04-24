package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class PlanificationVoyage  extends  AbstractDomainClass{
    
    
    private LocalDate heureDepart;
    private  LocalDate heureArrivee;
    private int nombrePlaces;
    private int nombrePlacesImage;
    private double montant;


    @ManyToOne
    @JoinColumn(name = "uuid_trajet" ,nullable = false)
    private Trajet trajet;

    @ManyToOne
    @JoinColumn(name = "uuid_vehicule" ,nullable = false)
    private Vehicule vehicule;
    
    @OneToOne
    private Utilisateur utilisateur;

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

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public PlanificationVoyage() {
		super();
		
	}

	public PlanificationVoyage(LocalDate heureDepart, LocalDate heureArrivee, int nombrePlaces, int nombrePlacesImage,
			double montant, Trajet trajet, Vehicule vehicule, Utilisateur utilisateur) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.nombrePlaces = nombrePlaces;
		this.nombrePlacesImage = nombrePlacesImage;
		this.montant = montant;
		this.trajet = trajet;
		this.vehicule = vehicule;
		this.utilisateur = utilisateur;
	}

}
	

