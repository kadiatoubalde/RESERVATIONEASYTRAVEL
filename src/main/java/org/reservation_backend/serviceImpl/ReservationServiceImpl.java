package org.reservation_backend.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.reservation_backend.Enum.StatutEnum;
import org.reservation_backend.Enum.StatutTrajet;
import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.ReservationDtoResponse;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.*;
import org.reservation_backend.repository.*;
import org.reservation_backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReservationServiceImpl implements ReservationService {


        private final TrajetRepository trajetRepository;
        private final ReservationRepository reservationRepository;
        private final UtilisateurService utilisateurService;
        private final PassagerRepository passagerRepository;
        private final UtilisateurRepository utilisateurRepository;

    public ReservationServiceImpl(TrajetRepository trajetRepository, ReservationRepository reservationRepository, UtilisateurService utilisateurService, PassagerRepository passagerRepository, UtilisateurRepository utilisateurRepository) {
        this.trajetRepository = trajetRepository;
        this.reservationRepository = reservationRepository;
        this.utilisateurService = utilisateurService;
        this.passagerRepository = passagerRepository;
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public ReservationDtoResponse reserverTrajet(ReservationDto dto) {
        // 1. Récupérer le trajet
        Trajet trajet = trajetRepository.findByUuid(dto.getTrajetUuid())
                .orElseThrow(() -> new RuntimeException("Trajet introuvable"));

        // 2. Vérifier la disponibilité des places
        int nombrePlacesTotal = trajet.getNombrePlaces();

        // Nombre total de billets déjà réservés pour ce trajet
        int totalBilletsReserves = reservationRepository
                .sumNombreBilletsByTrajetId(trajet.getUuid())  // À créer
                .orElse(0);

        int billetsDemandes = dto.getNombreBillets(); // <<< utilisé ici

        if (totalBilletsReserves + billetsDemandes > nombrePlacesTotal) {
            throw new RuntimeException("Le trajet ne dispose pas d’assez de places disponibles.");
        }

        // 3. Récupérer le passager connecté
        Utilisateur utilisateur = utilisateurService.getCurrentUser();

        // 4. Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setTrajet(trajet);
        reservation.setPassager(utilisateur);
        reservation.setNombreBillets(billetsDemandes); // <<< ici aussi
        reservation.setDate(LocalDate.now());
        reservation.setStatut(StatutEnum.EN_ATTENTE);
        reservation.setNumeroReservation("RES" + System.currentTimeMillis());

        // 5. Sauvegarder la réservation
        reservation = reservationRepository.save(reservation);

        // 6. Vérifier si le trajet est désormais complet
        if (totalBilletsReserves + billetsDemandes == nombrePlacesTotal) {
            trajet.setStatus(StatutTrajet.COMPLET);
            trajetRepository.save(trajet);
        }

        // 7. Retourner la réponse DTO
        return Mapper.toDtoReservation(reservation);
    }


    @Override
    public List<ReservationDtoResponse> mesReservations() {
        Utilisateur utilisateur = utilisateurService.getCurrentUser();
        utilisateur = utilisateurRepository.findByUuid(utilisateur.getUuid()).orElseThrow();
        List<Reservation> reservations = utilisateur.getReservations();

        return reservations.stream()
                .map(Mapper::toDtoReservation)
                .collect(Collectors.toList());
    }



}
