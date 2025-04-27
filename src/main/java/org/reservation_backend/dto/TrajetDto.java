package org.reservation_backend.dto;

public class TrajetDto {
	private String uuid;
	private String pointDepart;
	private String pointArriver;
	private String uuidPointDepart;
	private String uuidPointArriver;
	private double montant;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPointDepart() {
		return pointDepart;
	}
	public void setPointDepart(String pointDepart) {
		this.pointDepart = pointDepart;
	}
	public String getPointArriver() {
		return pointArriver;
	}
	public void setPointArriver(String pointArriver) {
		this.pointArriver = pointArriver;
	}
	public String getUuidPointDepart() {
		return uuidPointDepart;
	}
	public void setUuidPointDepart(String uuidPointDepart) {
		this.uuidPointDepart = uuidPointDepart;
	}
	public String getUuidPointArriver() {
		return uuidPointArriver;
	}
	public void setUuidPointArriver(String uuidPointArriver) {
		this.uuidPointArriver = uuidPointArriver;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public TrajetDto() {
		super();
	}
	
   
}
