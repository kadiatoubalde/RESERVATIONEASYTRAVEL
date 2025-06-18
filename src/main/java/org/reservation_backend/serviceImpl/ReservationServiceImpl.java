package org.reservation_backend.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.reservation_backend.Enum.StatutEnum;
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

            // 2. Récupérer le passager courant
            Utilisateur utilisateur = utilisateurService.getCurrentUser();
//            Passager passager = passagerRepository.findByTelephone(telephone)
//                    .orElseThrow(() -> new RuntimeException("Passager introuvable"));

            // 3. Créer la réservation
            Reservation reservation = new Reservation();
            reservation.setTrajet(trajet);
            reservation.setPassager(utilisateur);
            reservation.setNombreBagage(dto.getNombreBagage());
            reservation.setDate(LocalDate.now());
            reservation.setStatut(StatutEnum.EN_ATTENTE);
            reservation.setNumeroReservation("RES" + System.currentTimeMillis());

            // 4. Sauvegarder
            reservation = reservationRepository.save(reservation);

            // 5. Retourner le DTO
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
