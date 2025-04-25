package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.services.TrajetService;
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
@RequestMapping("api")
public class TrajetController {
	
	@Autowired
	private TrajetService trajetService;
	
	@PostMapping("trajet")
	public TrajetDto addTrajet(@RequestBody TrajetDto trajetDto) {
		return trajetService.addTrajet(trajetDto);
	}
	
	@PutMapping("trajet/{uuid}")
	public TrajetDto updateTrajet(@RequestBody TrajetDto trajetDto,@PathVariable String uuid) {
		return trajetService.updateTrajet(trajetDto, uuid);
	}
	
	@GetMapping("trajet/{uuid}")
	public TrajetDto getTrajet(@PathVariable String uuid) {
		return trajetService.getTrajet(uuid);
	}
	 @GetMapping("/trajet")
	 public List<TrajetDto> listeTrajet() {
		 return trajetService.listeTrajet();
	 }
	 
	 @DeleteMapping("/trajet/{uuid}") 
	 public boolean deleteTrajet(@PathVariable String uuid) {
		 return trajetService.deleteTrajet(uuid);
	 }
	
	

}
