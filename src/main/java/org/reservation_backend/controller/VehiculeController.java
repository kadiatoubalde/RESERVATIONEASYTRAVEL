package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.VehiculeDto;
import org.reservation_backend.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class VehiculeController {
	
	@Autowired
    private VehiculeService vehiculeService;
	
	@PostMapping("/vehicule")
    public ResponseEntity<VehiculeDto> addVehicule(@RequestBody VehiculeDto vehiculeDto) {
		VehiculeDto created = vehiculeService.addVehicule(vehiculeDto);
        return ResponseEntity.ok(created);
    }
	@PutMapping("/vehicule/{uuid}")
    public ResponseEntity<VehiculeDto> updateVehicule(@PathVariable String uuid, @RequestBody VehiculeDto vehiculeDto) {
		VehiculeDto updated = vehiculeService.addVehicule(vehiculeDto);
        return ResponseEntity.ok(updated);
    }
	@GetMapping("/vehicule/{uuid}")
    public ResponseEntity<VehiculeDto> getVehicule(@PathVariable String uuid) {
		VehiculeDto vehicule = vehiculeService.getVehicule(uuid);
		if(vehicule != null) {
			return ResponseEntity.ok(vehicule);
		} else {
			return ResponseEntity.notFound().build();
		}   
    }
	@GetMapping("/vehicule")
    public ResponseEntity<List<VehiculeDto>> listeVehicule() {
		List<VehiculeDto> liste = vehiculeService.listeVehicule();
        return ResponseEntity.ok(liste);
    }
	 @DeleteMapping("/vehicule/{uuid}")
	    public ResponseEntity<Void> deleteVehicule(@PathVariable String uuid) {
		 boolean deleted = vehiculeService.deleteVehicule(uuid);
		 if(deleted) {
			 return ResponseEntity.noContent().build();
		 } else {
			 return ResponseEntity.notFound().build();
		 }
	}
}
