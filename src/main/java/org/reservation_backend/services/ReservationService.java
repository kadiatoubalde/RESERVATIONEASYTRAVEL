package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Reservation;
import org.reservation_backend.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	 private final ReservationRepository reservationRepository;
	 
	 public ReservationService(ReservationRepository reservationRepository) {
	        this.reservationRepository = reservationRepository;
	    }
	 public Reservation creerReservation(Reservation reservation) {
	        return reservationRepository.save(reservation);
	    }
	 public Reservation getReservationParId(String uuid) {
	        return reservationRepository.findById(uuid)
	                .orElseThrow(() -> new IllegalArgumentException("Réservation non trouvée : " + uuid));
	    }
	 public List<Reservation> getToutesLesReservations() {
	        return reservationRepository.findAll(); 
	    }

	 public Reservation mettreAJourReservation(String uuid, Reservation nouvelleReservation) {
		    Reservation reservationExistante = reservationRepository.findById(uuid)
		        .orElseThrow(() -> new IllegalArgumentException("Réservation non trouvée : " + uuid));
		    
		    if (nouvelleReservation.getDate() != null) {
		        reservationExistante.setDate(nouvelleReservation.getDate());
		    }

		    if (nouvelleReservation.getStatut() != null) {
		        reservationExistante.setStatut(nouvelleReservation.getStatut());
		    }

		    if (nouvelleReservation.getNombreBagage() != 0) {
		        reservationExistante.setNombreBagage(nouvelleReservation.getNombreBagage());
		    }

		    if (nouvelleReservation.getNumeroReservation() != null) {
		        reservationExistante.setNumeroReservation(nouvelleReservation.getNumeroReservation());
		    }

		    if (nouvelleReservation.getPassager() != null) {
		        reservationExistante.setPassager(nouvelleReservation.getPassager());
		    }

		    if (nouvelleReservation.getPlanificationVoyage() != null) {
		        reservationExistante.setPlanificationVoyage(nouvelleReservation.getPlanificationVoyage());
		    }

		    if (nouvelleReservation.getUtilisateur() != null) {
		        reservationExistante.setUtilisateur(nouvelleReservation.getUtilisateur());
		    }

		    if (nouvelleReservation.getPaiement() != null) {
		        reservationExistante.setPaiement(nouvelleReservation.getPaiement());
		    }

		    return reservationRepository.save(reservationExistante);
		}
	 public void supprimerReservation(String uuid) {
	        Reservation reservation = reservationRepository.findById(uuid)
	                .orElseThrow(() -> new IllegalArgumentException("Réservation non trouvée : " + uuid));
	        reservationRepository.delete(reservation);
	    }
	 
	 

}
