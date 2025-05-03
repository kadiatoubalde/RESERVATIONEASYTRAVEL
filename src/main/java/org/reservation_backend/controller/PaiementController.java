package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.PaiementDto;
import org.reservation_backend.services.PaiementService;
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
@RequestMapping("api/paiement")
public class PaiementController {
	
	@Autowired
	private PaiementService paiementService;
	
   @PostMapping("/ajouter")
	public  ResponseEntity<PaiementDto> addPaiement(@RequestBody PaiementDto paiementDto) {
	   PaiementDto savedPaiement = paiementService.addPaiement(paiementDto);
        return ResponseEntity.ok(savedPaiement);
    }
  @PutMapping("/modifier/{uuid}")
	    public ResponseEntity<PaiementDto> updatePaiement(@RequestBody PaiementDto paiementDto, @PathVariable String uuid) {
	      PaiementDto updatedPaiement = paiementService.updatePaiement(paiementDto, uuid);
	        return ResponseEntity.ok(updatedPaiement);
	    }
  @GetMapping("/recuperer/{uuid}")
   public ResponseEntity<PaiementDto> getPaiement(@PathVariable String uuid) {
	  PaiementDto paiement = paiementService.getPaiement(uuid);
	     return ResponseEntity.ok(paiement);
	 }
  @GetMapping("/list")
  public ResponseEntity<List<PaiementDto>> listePaiement() {
	  List<PaiementDto> paiements = paiementService.listePaiement();
      return ResponseEntity.ok(paiements);
  }
  @DeleteMapping("/supprimer/{uuid}")
  public ResponseEntity<Void> deletePaiement(@PathVariable String uuid) {
	  boolean deleted = paiementService.deletePaiement(uuid);
	  if (deleted) {
		  return ResponseEntity.noContent().build();
	  } else {
		  return ResponseEntity.notFound().build();
	  }
	
  }

}
