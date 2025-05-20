package org.reservation_backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PlanificationVoyageDto {
	private String uuid;
	private LocalDate heureDepart;
	private LocalDate heureArrivee;
	private int nombrePlaces;
	private int nombrePlacesImage;
	private double montant;
	private String uuidTrajet;
	private String uuidVehicule;
	private String uuidUtilisateur;
}