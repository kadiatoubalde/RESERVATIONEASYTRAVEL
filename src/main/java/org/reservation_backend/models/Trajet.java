package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Trajet extends  AbstractDomainClass{

    @ManyToOne
    private Ville pointDepart;
    @ManyToOne
    private Ville pointArrive;
    private double montant;
    private LocalDate dateDepart;
	private LocalTime timeDepart;

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalTime getTimeDepart() {
		return timeDepart;
	}

	public void setTimeDepart(LocalTime timeDepart) {
		this.timeDepart = timeDepart;
	}

	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Ville getPointDepart() {
		return pointDepart;
	}
	public void setPointDepart(Ville pointDepart) {
		this.pointDepart = pointDepart;
	}
	public Ville getPointArrive() {
		return pointArrive;
	}
	public void setPointArrive(Ville pointArrive) {
		this.pointArrive = pointArrive;
	}
	public Trajet(Ville pointDepart, Ville pointArrive, double montant) {
		super();
		this.pointDepart = pointDepart;
		this.pointArrive = pointArrive;
		this.montant = montant;
	}
	public Trajet() {
		super();
		
	}


	@ManyToOne
	@JoinColumn(name = "chauffeur_id")
	private Utilisateur chauffeur;

	public Utilisateur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Utilisateur chauffeur) {
		this.chauffeur = chauffeur;
	}
}
