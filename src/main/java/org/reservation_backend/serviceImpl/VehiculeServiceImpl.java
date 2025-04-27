package org.reservation_backend.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.reservation_backend.dto.VehiculeDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Vehicule;
import org.reservation_backend.repository.VehiculeRepository;
import org.reservation_backend.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeServiceImpl  implements VehiculeService{
  
	@Autowired
	private VehiculeRepository vehiculeRepository;
	@Override
	public VehiculeDto addVehicule(VehiculeDto vehiculeDto) {
		Vehicule vehicule = new Vehicule();
        vehicule = Mapper.toEntityVehicule(vehiculeDto);

        if (!vehicule.equals(new Vehicule())) {
            vehicule = vehiculeRepository.save(vehicule);
        }

        return Mapper.toDtoVehicule(vehicule);
    }
	@Override
	public VehiculeDto updateVehicule(String uuid, VehiculeDto vehiculeDto) {
		Vehicule vehicule = vehiculeRepository.findById(uuid).orElseThrow();
        vehicule = Mapper.toEntityVehicule(vehiculeDto);
        vehicule.setUuid(uuid);
        if (!vehicule.equals(new Vehicule())) {
            vehicule = vehiculeRepository.save(vehicule);
        }
        return Mapper.toDtoVehicule(vehicule);
		
	}

	@Override
	public VehiculeDto getVehicule(String uuid) {
		Vehicule vehicule = vehiculeRepository.findById(uuid).orElseThrow();
        return Mapper.toDtoVehicule(vehicule);
    
	}

	@Override
	public List<VehiculeDto> listeVehicule() {
		 List<Vehicule> vehicules = vehiculeRepository.listes();
	        List<VehiculeDto> vehiculeDtos = new ArrayList<>();
	        vehicules.forEach(vehicule -> vehiculeDtos.add(Mapper.toDtoVehicule(vehicule)));
	        return vehiculeDtos;
	}

	@Override
	public boolean deleteVehicule(String uuid) {
		Vehicule vehicule = vehiculeRepository.findById(uuid).orElseThrow();
        if (!vehicule.isDelete()) {
            vehicule.setDelete(true);
            vehiculeRepository.save(vehicule);
        }
        return vehicule.isDelete();
    	}
}
