package org.reservation_backend.dto;

import java.time.LocalDate;

public class PaiementDto {
	private String uuid;
	private String numeroPaiement;
	private double  montant;
	private LocalDate  datePaiement;
	private String uuidModePaiement;
	private String uuidReservation;
	private String uuidUtilisateur;
	
	public String getUuidUtilisateur() {
		return uuidUtilisateur;
	}
	public void setUuidUtilisateur(String uuidUtilisateur) {
		this.uuidUtilisateur = uuidUtilisateur;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNumeroPaiement() {
		return numeroPaiement;
	}
	public void setNumeroPaiement(String numeroPaiement) {
		this.numeroPaiement = numeroPaiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public LocalDate getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	public String getUuidModePaiement() {
		return uuidModePaiement;
	}
	public void setUuidModePaiement(String uuidModePaiement) {
		this.uuidModePaiement = uuidModePaiement;
	}
	public String getUuidReservation() {
		return uuidReservation;
	}
	public void setUuidReservation(String uuidReservation) {
		this.uuidReservation = uuidReservation;
	}
	public PaiementDto() {
		super();
	}
	
		
	
}
