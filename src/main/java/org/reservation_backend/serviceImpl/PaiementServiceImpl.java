package org.reservation_backend.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.reservation_backend.dto.PaiementDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.ModePaiement;
import org.reservation_backend.models.Paiement;
import org.reservation_backend.models.Reservation;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.repository.ModePaiementRepository;
import org.reservation_backend.repository.PaiementRepository;
import org.reservation_backend.repository.ReservationRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.reservation_backend.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaiementServiceImpl implements PaiementService {
	@Autowired
	private PaiementRepository paiementRepository;
	@Autowired
	private ModePaiementRepository modePaiementRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private UtilisateurService utilisateurService;
	@Override
	public PaiementDto addPaiement(PaiementDto paiementDto) {

	    ModePaiement modePaiement = modePaiementRepository.findByUuid(paiementDto.getUuidModePaiement())
	        .orElseThrow(() -> new RuntimeException("Mode de paiement non trouvé"));

	    Reservation reservation = reservationRepository.findByUuid(paiementDto.getUuidReservation())
	        .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));

	  //  Utilisateur utilisateur = utilisateurRepository.findByUuid(paiementDto.getUuidUtilisateur())
	   //     .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

	    Paiement paiement = Mapper.toEntityPaiement(paiementDto);
	    paiement.setModePaiement(modePaiement);
	    paiement.setReservation(reservation);
	    paiement.setUtilisateur(utilisateurService.getCurrentUser());

	    paiement = paiementRepository.save(paiement);

	    return Mapper.toDtoPaiement(paiement);
	}
	@Override
	public PaiementDto updatePaiement(PaiementDto paiementDto, String uuid) {
		 Optional<ModePaiement> modePaiementOptional = modePaiementRepository.findById(paiementDto.getUuidModePaiement());
		    Optional<Reservation> reservationOptional = reservationRepository.findById(paiementDto.getUuidReservation());
		    Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(paiementDto.getUuidUtilisateur());

		    Paiement paiement = paiementRepository.findById(uuid).orElseThrow();
		    paiement = Mapper.toEntityPaiement(paiementDto);

		    if (modePaiementOptional.isPresent()) {
		        paiement.setModePaiement(modePaiementOptional.get());
		    }

		    if (reservationOptional.isPresent()) {
		        paiement.setReservation(reservationOptional.get());
		    }

		    if (utilisateurOptional.isPresent()) {
		        paiement.setUtilisateur(utilisateurOptional.get());
		    }

		    if (!paiement.equals(new Paiement())) {
		        paiement = paiementRepository.save(paiement);
		    }
		    return Mapper.toDtoPaiement(paiement);
	}
	@Override
	public PaiementDto getPaiement(String uuid) {
		Paiement paiement = paiementRepository.findById(uuid).orElseThrow();
        return Mapper.toDtoPaiement(paiement);
		
	}
	@Override
	public List<PaiementDto> listePaiement() {
		List<Paiement> paiements = paiementRepository.listes();
        List<PaiementDto> paiementDtos = new ArrayList<>();
        paiements.forEach(paiement -> paiementDtos.add(Mapper.toDtoPaiement(paiement)));
        return paiementDtos;
	}
	@Override
	public boolean deletePaiement(String uuid) {
		 Paiement paiement = paiementRepository.findById(uuid).orElseThrow();
	        if (!paiement.isDelete()) {
	            paiement.setDelete(true);
	            paiementRepository.save(paiement);
	        }
	        return paiement.isDelete();
	}

}
