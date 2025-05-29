package org.reservation_backend.controller;

import java.util.List;
import org.reservation_backend.dto.VilleDto;
import org.reservation_backend.services.VilleService;
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
@RequestMapping("/ville")
public class VilleController {
	@Autowired
	private VilleService villeService;
	
	@PostMapping("/ville")
	public ResponseEntity<VilleDto> addVille(@RequestBody VilleDto villeDto) {
		VilleDto created =villeService.addVille(villeDto);
		return ResponseEntity.ok(created);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<VilleDto> updateVille(@RequestBody VilleDto villeDto,@PathVariable String uuid) {
		VilleDto updated = villeService.updateVille(villeDto, uuid);
		return ResponseEntity.ok(updated);
	}
	
	@GetMapping("/ville/{uuid}")
	public ResponseEntity<VilleDto> getVille(@PathVariable String uuid) {
		VilleDto ville = villeService.getVille(uuid);
		if(ville != null) {
			return ResponseEntity.ok(ville);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/ville")
	public ResponseEntity<List<VilleDto>> listeVille() {
		List<VilleDto> liste = villeService.listeVille();
		return ResponseEntity.ok(liste);
	}
	
	 @DeleteMapping("/ville/{uuid}")
	 public ResponseEntity<Void> deleteVille(@PathVariable String uuid) {
		 boolean deleted = villeService.deleteVille(uuid);
		 if(deleted) {
			 return ResponseEntity.noContent().build();
		 } else {
			 return ResponseEntity.notFound().build();
		 }
	 }
}
