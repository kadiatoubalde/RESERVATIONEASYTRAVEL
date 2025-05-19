package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.services.TrajetService;
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
public class TrajetController {
	
	@Autowired
	private TrajetService trajetService;
	
	@PostMapping("/trajet")
	public ResponseEntity<TrajetDto> addTrajet(@RequestBody TrajetDto trajetDto) {
		TrajetDto createdTrajet = trajetService.addTrajet(trajetDto);
		return ResponseEntity.ok(createdTrajet);
	}
	
	@PutMapping("/trajet/{uuid}")
	public  ResponseEntity<TrajetDto> updateTrajet(@RequestBody TrajetDto trajetDto,@PathVariable String uuid) {
		TrajetDto updatedTrajet = trajetService.updateTrajet(trajetDto, uuid);
		return ResponseEntity.ok(updatedTrajet);
	}
	
	@GetMapping("/trajet/{uuid}")
	public ResponseEntity<TrajetDto> getTrajet(@PathVariable String uuid) {
		TrajetDto trajet = trajetService.getTrajet(uuid);
		if(trajet != null) {
			return ResponseEntity.ok(trajet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	 @GetMapping("/trajet")
	 public  ResponseEntity<List<TrajetDto>> listeTrajet() {
		 List<TrajetDto> trajets = trajetService.listeTrajet();
		 return ResponseEntity.ok(trajets);
	 }
	 
	 @DeleteMapping("/trajet/{uuid}") 
	 public ResponseEntity<Void> deleteTrajet(@PathVariable String uuid) {
		 boolean deleted = trajetService.deleteTrajet(uuid);
		 if(deleted) {
			 return ResponseEntity.noContent().build();
		 }else {
			 return ResponseEntity.notFound().build();
		 }	 
	 }
}
