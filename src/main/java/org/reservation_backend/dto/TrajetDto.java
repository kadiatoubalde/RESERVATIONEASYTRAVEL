package org.reservation_backend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


public class TrajetDto {
	private String uuid;
	private String pointDepart;
	private String pointArriver;
	private String uuidPointDepart;
	private String uuidPointArriver;
	private LocalDate dateDepart;
	private LocalTime timeDepart;
	private double montant;
	private String chauffeurId;


	public String getChauffeurId() {
		return chauffeurId;
	}

	public void setChauffeurId(String chauffeurId) {
		this.chauffeurId = chauffeurId;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalTime getTimeDepart() {
		return timeDepart;
	}

	public void setTimeDepart(LocalTime timeDepart) {
		this.timeDepart = timeDepart;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getUuidPointArriver() {
		return uuidPointArriver;
	}

	public void setUuidPointArriver(String uuidPointArriver) {
		this.uuidPointArriver = uuidPointArriver;
	}

	public String getUuidPointDepart() {
		return uuidPointDepart;
	}

	public void setUuidPointDepart(String uuidPointDepart) {
		this.uuidPointDepart = uuidPointDepart;
	}

	public String getPointArriver() {
		return pointArriver;
	}

	public void setPointArriver(String pointArriver) {
		this.pointArriver = pointArriver;
	}

	public String getPointDepart() {
		return pointDepart;
	}

	public void setPointDepart(String pointDepart) {
		this.pointDepart = pointDepart;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
