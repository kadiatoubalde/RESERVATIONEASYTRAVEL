package org.reservation_backend.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class ModePaiement extends AbstractDomainClass {
	private String libelle;
	private String Description;
	
	
	@OneToMany(mappedBy = "modePaiement")
	private List<Paiement> paiement;


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


	public List<Paiement> getPaiement() {
		return paiement;
	}


	public void setPaiement(List<Paiement> paiement) {
		this.paiement = paiement;
	}


	public ModePaiement() {
		super();
		
	}


	public ModePaiement(String libelle, String description, List<Paiement> paiement) {
		super();
		this.libelle = libelle;
		Description = description;
		this.paiement = paiement;
	}
	
 
}