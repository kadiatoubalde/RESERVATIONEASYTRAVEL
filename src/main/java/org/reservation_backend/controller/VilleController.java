package org.reservation_backend.controller;

import java.util.List;
import org.reservation_backend.dto.VilleDto;
import org.reservation_backend.services.VilleService;
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
public class VilleController {
	@Autowired
	private VilleService villeService;
	
	@PostMapping("/ville")
	public VilleDto addVille(@RequestBody VilleDto villeDto) {
		return villeService.addVille(villeDto);
	}

	@PutMapping("/ville/{uuid}")
	public VilleDto updateVille(@RequestBody VilleDto villeDto,@PathVariable String uuid) {
		return villeService.updateVille(villeDto,uuid);
	}
	
	@GetMapping("/ville/{uuid}")
	public VilleDto getVille(@PathVariable String uuid) {
		return villeService.getVille(uuid);
	}
	
	@GetMapping("/ville")
	public List<VilleDto> listeVille() {
		return villeService.listeVille();
	}
	
	 @DeleteMapping("/ville/{uuid}")
	 public boolean deleteVille(@PathVariable String uuid) {
		 return villeService.deleteVille(uuid);
	 }
}
