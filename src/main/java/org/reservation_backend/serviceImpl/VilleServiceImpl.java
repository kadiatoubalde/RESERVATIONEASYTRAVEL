package org.reservation_backend.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.reservation_backend.dto.VilleDto;
import org.reservation_backend.fonction.Fonction;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Ville;
import org.reservation_backend.repository.VilleRepository;
import org.reservation_backend.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VilleServiceImpl  implements VilleService{
	@Autowired
	private VilleRepository villeRepository;

	@Override
	public VilleDto addVille(VilleDto villeDto) {
		// Vérifier si une ville avec le même nom (sans tenir compte de la casse) existe
		Optional<Ville> existingVille = villeRepository.findByLibelleIgnoreCase(villeDto.getNom());

		if (existingVille.isPresent()) {
			throw new RuntimeException("La ville '" + villeDto.getNom() + "' existe déjà !");
		}

		Ville ville = Mapper.toEntityVille(villeDto);
		Ville savedVille = villeRepository.save(ville);
		return Mapper.toDtoVille(savedVille);
	}


	@Override
	public VilleDto updateVille(VilleDto villeDto, String uuid) {
		Ville ville = villeRepository.findById(uuid).orElseThrow();
		ville.setLibelle(villeDto.getNom());
		ville = villeRepository.save(ville);
		return  Mapper.toDtoVille(ville);
	}

	@Override
	public VilleDto getVille(String uuid) {
		Ville ville = villeRepository.findById(uuid).orElseThrow();
		return Mapper.toDtoVille(ville);
		// TODO Auto-generated method stub
	}

	public Ville findByUuid(String uuid) {
		return villeRepository.findByUuid(uuid).orElseThrow();
	}

	@Override
	public List<VilleDto> listeVille() {
		List<Ville> villes = villeRepository.findAll();
		List<VilleDto> villeDtos = new ArrayList();
		villes.forEach(ville -> villeDtos.add(Mapper.toDtoVille(ville)));
		return villeDtos;
		// TODO Auto-generated method stub
	}

//	@Override
//	public boolean deleteVille(String uuid) {
//		Ville ville = villeRepository.findById(uuid).orElseThrow();
//		if(!ville.isDelete()) {
//			ville.setDelete(true);
//			villeRepository.save(ville);
//		}
//		// TODO Auto-generated method stub
//		return ville.isDelete();
//	}

	@Override
	public boolean deleteVille(String uuid) {
		villeRepository.deleteById(uuid);
		return true;
	}

}
