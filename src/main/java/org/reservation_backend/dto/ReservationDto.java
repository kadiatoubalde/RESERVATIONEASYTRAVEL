package org.reservation_backend.dto;

import java.time.LocalDate;

import org.reservation_backend.Enum.StatutEnum;

public class ReservationDto {
	private String uuid;
	private LocalDate date;
    private  StatutEnum statut ;
    private  int   nombreBagage;
    private  String numeroReservation;
    private String uuidPassager;
    private String uuidUtilisateur;
    
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
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
	public String getUuidPassager() {
		return uuidPassager;
	}
	public void setUuidPassager(String uuidPassager) {
		this.uuidPassager = uuidPassager;
	}
	public String getUuidUtilisateur() {
		return uuidUtilisateur;
	}
	public void setUuidUtilisateur(String uuidUtilisateur) {
		this.uuidUtilisateur = uuidUtilisateur;
	}
	public ReservationDto() {
		super();
	}
	
}
