package org.reservation_backend.dto;

import java.time.LocalDate;

public class PaiementDto {
	private String uuid;
	private String numeroPaiement;
	private double  montant;
	private LocalDate  datePaiement;
	private String uuidModePaiement;
	private String uuidReservation;
	private String uuiUtilisateur;
	
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
	public String getUuiUtilisateur() {
		return uuiUtilisateur;
	}
	public void setUuiUtilisateur(String uuiUtilisateur) {
		this.uuiUtilisateur = uuiUtilisateur;
	}
	public PaiementDto() {
		super();
	}
	public PaiementDto(String uuid, String numeroPaiement, double montant, LocalDate datePaiement,
			String uuidModePaiement, String uuidReservation, String uuiUtilisateur) {
		super();
		this.uuid = uuid;
		this.numeroPaiement = numeroPaiement;
		this.montant = montant;
		this.datePaiement = datePaiement;
		this.uuidModePaiement = uuidModePaiement;
		this.uuidReservation = uuidReservation;
		this.uuiUtilisateur = uuiUtilisateur;
	}
		
	
}
