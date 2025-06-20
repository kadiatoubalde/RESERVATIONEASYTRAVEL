package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.dto.SearchTrajetDto;
import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.models.Trajet;
import org.springframework.stereotype.Service;


@Service
public interface TrajetService {
 
	TrajetDto addTrajet(TrajetDto trajetDto);
	TrajetDto updateTrajet(TrajetDto trajetDto,String uuid);
	Trajet getTrajet(String uuid);
	List<TrajetDto> listeTrajet();
	boolean deleteTrajet(String uuid);


    String attribuer(String trajetId, String chauffeurId);

	List<Trajet> rechercherTrajets(SearchTrajetDto dto);

	boolean changeStatus(String uuid, String status);

    List<PassagerDto> getPassagerByTrajets();
}
