package org.reservation_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.reservation_backend.Enum.StatutEnum;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Reservation  extends AbstractDomainClass{
    private LocalDate date;
    
    private  StatutEnum statut ;
    private  int     nombreBagage;
    private  String numeroReservation;
//    @ManyToOne
//    @JoinColumn(name = "numero_passager",nullable = false)
//    private  Passager passager;
    
//    @ManyToOne
//    @JoinColumn(name = "uuid_planificationVoyage",nullable = false)
//    private  PlanificationVoyage planificationVoyage;

    @OneToOne(mappedBy = "reservation")
    private Paiement paiement;


	@ManyToOne
	@JoinColumn(name = "personne_id")
	private Utilisateur passager;

	@ManyToOne
	@JoinColumn(name = "trajet_id")
	private Trajet trajet;

    private int nombreBillets;

}
