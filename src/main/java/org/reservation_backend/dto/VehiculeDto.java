package org.reservation_backend.dto;

import java.util.List;

import org.reservation_backend.Enum.EnumTypeVehicule;

public class VehiculeDto {
	private String uuid;
	private String marque;
    private String immatriculation;
    private String description;
    private EnumTypeVehicule enumTypeVehicule; 
    private int nombrePlace;
    private String modele;
    
    private List<PlanificationVoyageDto> planificationVoyages;

    
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnumTypeVehicule getEnumTypeVehicule() {
		return enumTypeVehicule;
	}

	public void setEnumTypeVehicule(EnumTypeVehicule enumTypeVehicule) {
		this.enumTypeVehicule = enumTypeVehicule;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public List<PlanificationVoyageDto> getPlanificationVoyages() {
		return planificationVoyages;
	}

	public void setPlanificationVoyages(List<PlanificationVoyageDto> planificationVoyages) {
		this.planificationVoyages = planificationVoyages;
	}

	public VehiculeDto() {
		super();
	}

	public VehiculeDto(String uuid, String marque, String immatriculation, String description,
			EnumTypeVehicule enumTypeVehicule, int nombrePlace, String modele,
			List<PlanificationVoyageDto> planificationVoyages) {
		super();
		this.uuid = uuid;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.description = description;
		this.enumTypeVehicule = enumTypeVehicule;
		this.nombrePlace = nombrePlace;
		this.modele = modele;
		this.planificationVoyages = planificationVoyages;
	}

    

}
