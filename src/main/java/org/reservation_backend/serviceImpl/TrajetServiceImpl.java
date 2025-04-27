package org.reservation_backend.serviceImpl;

import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Trajet;
import org.reservation_backend.repository.TrajetRepository;
import org.reservation_backend.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetServiceImpl  implements TrajetService{
	
    @Autowired
	private TrajetRepository trajetRepository;
     
	/**
	 * @param trajetDto
	 * @return
	 */
	@Override
	public TrajetDto addTrajet(TrajetDto trajetDto) {
		Trajet trajet = new Trajet();
	    trajet = Mapper.toEntityTrajet(trajetDto);
		
		if (!trajet.equals(new Trajet())) {
			trajet = trajetRepository.save(trajet);
		}
		return  Mapper.toDtoTrajet(trajet);
	}

	/**
	 * @param trajetDto
	 * @param uuid
	 * @return
	 */
	@Override
	public TrajetDto updateTrajet(TrajetDto trajetDto, String uuid) {
		Trajet trajet = trajetRepository.findById(uuid).orElseThrow();
		 trajet = Mapper.toEntityTrajet(trajetDto);
		  
		 if(!trajet.equals(new Trajet())) {
			 trajet = trajetRepository.save(trajet);
		 }
		 
		return  Mapper.toDtoTrajet(trajet);
	}
     
	/**
	 * @param uuid
	 * @return
	 */
	@Override
	public TrajetDto getTrajet(String uuid) {
		Trajet trajet = trajetRepository.findById(uuid).orElseThrow();
		return Mapper.toDtoTrajet(trajet);
	}

	/**
	 * @return
	 */
	@Override
	public List<TrajetDto> listeTrajet() {
		List<Trajet> trajets = trajetRepository.findAll();
		List<TrajetDto> trajetDtos = new  ArrayList();
		trajets.forEach(trajet -> trajetDtos.add(Mapper.toDtoTrajet(trajet)));
		return trajetDtos;
	}

	/**
	 * @param uuid
	 * @return
	 */
	@Override
	public boolean deleteTrajet(String uuid) {
		Trajet trajet = trajetRepository.findById(uuid).orElseThrow();
		if (!trajet.isDelete()) {
			trajet.setDelete(true);
			trajetRepository.save(trajet);
		}
		return trajet.isDelete();
	}
}
