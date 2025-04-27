package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.services.ModePaiementService;
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
public class ModePaiementController {
    @Autowired
	private ModePaiementService modePaiementService;
    
    @PostMapping("/modePaiement")
    public ModePaiementDto addModePaiement(@RequestBody ModePaiementDto modePaiementDto) {
    	return modePaiementService.addModePaiement(modePaiementDto);
    }
    @PutMapping("/modePaiement/{uuid}")
    public ModePaiementDto updateModePaiement(@RequestBody ModePaiementDto modePaiementDto, @PathVariable String uuid) {
        return modePaiementService.updateModePaiement(modePaiementDto, uuid);
    }
    @GetMapping("/modePaiement/{uuid}")
    public ModePaiementDto getModePaiement(@PathVariable String uuid) {
        return modePaiementService.getModePaiement(uuid);
    }
    @GetMapping("/modePaiement")
    public List<ModePaiementDto> list() {
        return modePaiementService.listesModePaiement();
    }
    @DeleteMapping("/modePaiement/{uuid}")
    public boolean deleteModePaiement(@PathVariable String uuid) {
        return modePaiementService.delete(uuid);
    }

	
	

}
