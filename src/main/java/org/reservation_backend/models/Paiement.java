package org.reservation_backend.models;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Paiement extends AbstractDomainClass{
    private String numeroPaiement;
    private LocalDate datePaiement;
    private  double montant;

     
    @ManyToOne
    @JoinColumn(name = "uuid_modepaiement" ,nullable = false)
    private ModePaiement modePaiement;
    
    
    @OneToOne
    @JoinColumn(name = "uuid_reservation",nullable = false)
    private Reservation reservation;
    
    @OneToOne
    private Utilisateur utilisateur;

	public String getNumeroPaiement() {
		return numeroPaiement;
	}

	public void setNumeroPaiement(String numeroPaiement) {
		this.numeroPaiement = numeroPaiement;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Paiement() {
		super();
	
	}

	public Paiement(String numeroPaiement, LocalDate datePaiement, double montant, ModePaiement modePaiement,
			Reservation reservation, Utilisateur utilisateur) {
		super();
		this.numeroPaiement = numeroPaiement;
		this.datePaiement = datePaiement;
		this.montant = montant;
		this.modePaiement = modePaiement;
		this.reservation = reservation;
		this.utilisateur = utilisateur;
	}

	
	


    
}
