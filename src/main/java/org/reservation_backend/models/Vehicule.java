package org.reservation_backend.models;

import java.util.List;
import org.reservation_backend.Enum.EnumTypeVehicule;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicule extends AbstractDomainClass{

    private String marque;
    private String immatriculation;
    private String description;
    private EnumTypeVehicule enumTypeVehicule; 
    private int nombrePlace;
    private String modele;
    
    @OneToMany(mappedBy = "vehicule")
    private List<PlanificationVoyage>  voyages;
    
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
	public Vehicule() {
		super();
	}
	public Vehicule(String marque, String immatriculation, String description, EnumTypeVehicule enumTypeVehicule,
			int nombrePlace, String modele) {
		super();
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.description = description;
		this.enumTypeVehicule = enumTypeVehicule;
		this.nombrePlace = nombrePlace;
		this.modele = modele;
	}
    
}
