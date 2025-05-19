package org.reservation_backend.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Paiement;
import org.reservation_backend.models.Passager;
import org.reservation_backend.models.Reservation;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.repository.PaiementRepository;
import org.reservation_backend.repository.PassagerRepository;
import org.reservation_backend.repository.ReservationRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.reservation_backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReservationServiceImpl implements ReservationService {

	    @Autowired
	    private ReservationRepository reservationRepository;
	    
	    @Autowired
	    private PassagerRepository passagerRepository;

	    @Autowired
	    private PaiementRepository paiementRepository;
	    
	    @Autowired
	    private UtilisateurRepository utilisateurRepository;
	@Override
	public ReservationDto addReservation(ReservationDto reservationDto) {
		Optional<Passager> passagerOptional = passagerRepository.findById(reservationDto.getUuidPassager());
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(reservationDto.getUuidUtilisateur());
        
        Reservation reservation = Mapper.toEntityReservation(reservationDto);
        if (passagerOptional.isPresent()) {
            reservation.setPassager(passagerOptional.get());
        }

        if (utilisateurOptional.isPresent()) {
            reservation.setUtilisateur(utilisateurOptional.get());
        }
        if (!reservation.equals(new Reservation())) {
            reservation = reservationRepository.save(reservation);
        }
        return Mapper.toDtoReservation(reservation);
	}
	@Override
	public ReservationDto updateReservation(ReservationDto reservationDto, String uuid) {
	  Optional<Passager> passagerOptional = passagerRepository.findById(reservationDto.getUuidPassager());
	  Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(reservationDto.getUuidUtilisateur());
	  Reservation reservation = new Reservation();
	  reservation = Mapper.toEntityReservation(reservationDto);
	  if (passagerOptional.isPresent()) {
	        reservation.setPassager(passagerOptional.get());
	    }



	    if (utilisateurOptional.isPresent()) {
	        reservation.setUtilisateur(utilisateurOptional.get());
	    }
	    if (!reservation.equals(new Reservation())) {
	        reservation = reservationRepository.save(reservation);
	    }

	    return Mapper.toDtoReservation(reservation);

	}
	@Override
	public ReservationDto getReservation(String uuid) {
		 Reservation reservation = reservationRepository.findById(uuid).orElseThrow();
		 return Mapper.toDtoReservation(reservation);      
	}
	@Override
	public List<ReservationDto> listeReservation() {
		 List<Reservation> reservations = reservationRepository.listes();
		 List<ReservationDto> reservationDtos = new ArrayList<>();
		 reservations.forEach(reservation -> reservationDtos.add(Mapper.toDtoReservation(reservation))); 
		 return reservationDtos;   
	}
	@Override
	public boolean deleteReservation(String uuid) {
		  Reservation reservation = reservationRepository.findById(uuid).orElseThrow();
		  if (!reservation.isDelete()) {
		     reservation.setDelete(true);
		     reservationRepository.save(reservation);
		  }
		  return reservation.isDelete();
	}
}
