package org.reservation_backend.dto;

import lombok.Data;
import org.reservation_backend.Enum.StatutTrajet;
import org.reservation_backend.Enum.TypeVehicule;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
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
    private StatutTrajet status;
	private int nombrePlaces;
	private TypeVehicule typeVehicule;
}
