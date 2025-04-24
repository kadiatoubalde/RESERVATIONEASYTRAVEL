package org.reservation_backend.dto;

import java.util.List;

import org.reservation_backend.models.Paiement;

public class ModePaiementDto {
    private String uuid;
	private String libelle;
	private String Description;
	private List<PaiementDto> paiement;
	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<PaiementDto> getPaiement() {
		return paiement;
	}

	public void setPaiement(List<PaiementDto> paiement) {
		this.paiement = paiement;
	}

	public ModePaiementDto() {
		super();
	}

	public ModePaiementDto(String uuid, String libelle, String description, List<PaiementDto> paiement) {
		super();
		this.uuid = uuid;
		this.libelle = libelle;
		Description = description;
		this.paiement = paiement;
	}

  

	
}
