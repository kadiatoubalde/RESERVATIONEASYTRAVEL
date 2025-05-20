package org.reservation_backend.dto;

import lombok.Data;

@Data
public class TrajetDto {
	private String uuid;
	private String pointDepart;
	private String pointArriver;
	private String uuidPointDepart;
	private String uuidPointArriver;
	private double montant;

}
