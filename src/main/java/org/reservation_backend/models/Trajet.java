package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Trajet extends  AbstractDomainClass{

    @ManyToOne
    private Ville pointDepart;
    @ManyToOne
    private Ville pointArrive;
    private double montant;
    
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Ville getPointDepart() {
		return pointDepart;
	}
	public void setPointDepart(Ville pointDepart) {
		this.pointDepart = pointDepart;
	}
	public Ville getPointArrive() {
		return pointArrive;
	}
	public void setPointArrive(Ville pointArrive) {
		this.pointArrive = pointArrive;
	}
	public Trajet(Ville pointDepart, Ville pointArrive, double montant) {
		super();
		this.pointDepart = pointDepart;
		this.pointArrive = pointArrive;
		this.montant = montant;
	}
	public Trajet() {
		super();
		
	}
	
   

   

    }
