package org.reservation_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Ville extends  AbstractDomainClass{

    @Column(length = 100,unique = true )
    private String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Ville() {
		super();
	}

	public Ville(String libelle) {
		super();
		this.libelle = libelle;
	}
	

}
