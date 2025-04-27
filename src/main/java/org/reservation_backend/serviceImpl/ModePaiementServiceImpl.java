package org.reservation_backend.serviceImpl;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.ModePaiement;
import org.reservation_backend.repository.ModePaiementRepository;
import org.reservation_backend.services.ModePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModePaiementServiceImpl implements ModePaiementService {
    
	@Autowired
	private ModePaiementRepository modePaiementRepository;
	
	@Override
	public ModePaiementDto addModePaiement(ModePaiementDto modePaiementDto) {
		ModePaiement modePaiement = new ModePaiement();
		modePaiement = Mapper.toEntityModePaiement(modePaiementDto);
		if (!modePaiement.equals( new ModePaiement())) {
			modePaiement = modePaiementRepository.save(modePaiement);
		}
		return Mapper.toDtoModePaiement(modePaiement);
		
	}

	@Override
	public ModePaiementDto updateModePaiement(ModePaiementDto modePaiementDto, String uuid) {
	ModePaiement modePaiement = modePaiementRepository.findById(uuid).orElseThrow();
	modePaiement = Mapper.toEntityModePaiement(modePaiementDto);
	
	if(!modePaiement.equals(new ModePaiement())) {
		modePaiement = modePaiementRepository.save(modePaiement);
	}
		
		return Mapper.toDtoModePaiement(modePaiement);
	}

	@Override
	public List<ModePaiementDto> listesModePaiement() {
		List<ModePaiement> modePaiements = modePaiementRepository.listes();
		List<ModePaiementDto> modePaiementDtos = new ArrayList<> ();
		modePaiements.forEach(modePaiement -> modePaiementDtos.add(Mapper.toDtoModePaiement(modePaiement)));
		return modePaiementDtos;
	}

	@Override
	public ModePaiementDto getModePaiement(String uuid) {
		ModePaiement modePaiement = modePaiementRepository.findById(uuid).orElseThrow();
		return  Mapper.toDtoModePaiement(modePaiement);
	}

	@Override
	public boolean delete(String uuid) {
		ModePaiement modePaiement = modePaiementRepository.findById(uuid).orElseThrow();
		if(!modePaiement.isDelete()) {
			modePaiement.setDelete(true);
			modePaiementRepository.save(modePaiement);
		}
		
		return modePaiement.isDelete();
	}
   
}
