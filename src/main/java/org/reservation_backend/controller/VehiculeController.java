package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.VehiculeDto;
import org.reservation_backend.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
	
	@Autowired
    private VehiculeService vehiculeService;
	
	@PostMapping("/vehicule")
    public VehiculeDto addVehicule(@RequestBody VehiculeDto vehiculeDto) {
        return vehiculeService.addVehicule(vehiculeDto);
    }
	@PutMapping("/vehicule/{uuid}")
    public VehiculeDto updateVehicule(@PathVariable String uuid, @RequestBody VehiculeDto vehiculeDto) {
        return vehiculeService.updateVehicule(uuid, vehiculeDto);
    }
	@GetMapping("/vehicule/{uuid}")
    public VehiculeDto getVehicule(@PathVariable String uuid) {
        return vehiculeService.getVehicule(uuid);
    }
	@GetMapping("/vehicule")
    public List<VehiculeDto> listeVehicule() {
        return vehiculeService.listeVehicule();
    }
	 @DeleteMapping("/vehicule/{uuid}")
	    public boolean deleteVehicule(@PathVariable String uuid) {
	        return vehiculeService.deleteVehicule(uuid);
	    }
}
