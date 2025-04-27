package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.VehiculeDto;

public interface VehiculeService {
	VehiculeDto addVehicule(VehiculeDto vehiculeDto);
    VehiculeDto updateVehicule(String uuid, VehiculeDto vehiculeDto);
    VehiculeDto getVehicule(String uuid);
    List<VehiculeDto> listeVehicule();
    boolean deleteVehicule(String uuid);
	
}
