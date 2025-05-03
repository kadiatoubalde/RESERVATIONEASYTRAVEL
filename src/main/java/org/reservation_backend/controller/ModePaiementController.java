package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.services.ModePaiementService;
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
public class ModePaiementController {
    @Autowired
	private ModePaiementService modePaiementService;
    
    @PostMapping("/modePaiement")
    public ResponseEntity<ModePaiementDto>  addModePaiement(@RequestBody ModePaiementDto modePaiementDto) {
    	ModePaiementDto saved = modePaiementService.addModePaiement(modePaiementDto);
    	return  ResponseEntity.ok(saved);
    }
    @PutMapping("/modePaiement/{uuid}")
    public  ResponseEntity<ModePaiementDto> updateModePaiement(@RequestBody ModePaiementDto modePaiementDto, @PathVariable String uuid) {
    	ModePaiementDto updated = modePaiementService.updateModePaiement(modePaiementDto, uuid);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/modePaiement/{uuid}")
    public ResponseEntity<ModePaiementDto> getModePaiement(@PathVariable String uuid) {
    	ModePaiementDto result = modePaiementService.getModePaiement(uuid);
    	if(result != null) {
    		return ResponseEntity.ok(result);
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/modePaiement")
    public ResponseEntity<List<ModePaiementDto>> list() {
    	List<ModePaiementDto> list = modePaiementService.listesModePaiement();
        return ResponseEntity.ok(list);
    }
    @DeleteMapping("/modePaiement/{uuid}")
    public ResponseEntity<Void> deleteModePaiement(@PathVariable String uuid) {
    	boolean deleted = modePaiementService.delete(uuid);
    	if(deleted) {
    		return ResponseEntity.noContent().build();
    	} else {
    		
    	}
        return ResponseEntity.notFound().build();
    }

}
