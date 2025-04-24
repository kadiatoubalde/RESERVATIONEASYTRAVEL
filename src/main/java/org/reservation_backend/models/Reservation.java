package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import org.reservation_backend.Enum.StatutEnum;
@Entity
public class Reservation  extends AbstractDomainClass{
    private LocalDate date;
    private  StatutEnum statut ;
    private  int     nombreBagage;
    private  String numeroReservation;
    @ManyToOne
    @JoinColumn(name = "numero_passager",nullable = false)
    private  Passager passager;
    
    @ManyToOne
    @JoinColumn(name = "uuid_planificationVoyage",nullable = false)
    private  PlanificationVoyage planificationVoyage;

    @OneToOne(mappedBy = "reservation")
    private Paiement paiement;
    

    @OneToOne
    private Utilisateur utilisateur;


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public StatutEnum getStatut() {
		return statut;
	}


	public void setStatut(StatutEnum statut) {
		this.statut = statut;
	}


	public int getNombreBagage() {
		return nombreBagage;
	}


	public void setNombreBagage(int nombreBagage) {
		this.nombreBagage = nombreBagage;
	}


	public String getNumeroReservation() {
		return numeroReservation;
	}


	public void setNumeroReservation(String numeroReservation) {
		this.numeroReservation = numeroReservation;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
	}


	public PlanificationVoyage getPlanificationVoyage() {
		return planificationVoyage;
	}


	public void setPlanificationVoyage(PlanificationVoyage planificationVoyage) {
		this.planificationVoyage = planificationVoyage;
	}


	public Paiement getPaiement() {
		return paiement;
	}


	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Reservation() {
		super();
	}


	public Reservation(LocalDate date, StatutEnum statut, int nombreBagage, String numeroReservation, Passager passager,
			PlanificationVoyage planificationVoyage, Paiement paiement, Utilisateur utilisateur) {
		super();
		this.date = date;
		this.statut = statut;
		this.nombreBagage = nombreBagage;
		this.numeroReservation = numeroReservation;
		this.passager = passager;
		this.planificationVoyage = planificationVoyage;
		this.paiement = paiement;
		this.utilisateur = utilisateur;
	}


	


	
    
}
