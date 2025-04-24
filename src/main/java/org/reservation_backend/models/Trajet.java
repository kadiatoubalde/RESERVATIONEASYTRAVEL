package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Trajet extends  AbstractDomainClass{

    @ManyToOne
    private Ville pointDepart;
    @ManyToOne
    private Ville pointArrive;
    
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
	public Trajet() {
		super();

	}
	public Trajet(Ville pointDepart, Ville pointArrive) {
		super();
		this.pointDepart = pointDepart;
		this.pointArrive = pointArrive;
	}
   

   

    }
