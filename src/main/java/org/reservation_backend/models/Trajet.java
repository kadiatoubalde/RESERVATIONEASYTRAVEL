package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.reservation_backend.Enum.StatutTrajet;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Trajet extends  AbstractDomainClass{

    @ManyToOne
    private Ville pointDepart;
    @ManyToOne
    private Ville pointArrive;
    private double montant;
    private LocalDate dateDepart;
	private LocalTime timeDepart;
	private StatutTrajet status = StatutTrajet.PLANIFIE;
	public Trajet(Ville pointDepart, Ville pointArrive, double montant) {
		super();
		this.pointDepart = pointDepart;
		this.pointArrive = pointArrive;
		this.montant = montant;
	}
	public Trajet() {
		super();

	}


	@ManyToOne
	@JoinColumn(name = "chauffeur_id")
	private Utilisateur chauffeur;

}
