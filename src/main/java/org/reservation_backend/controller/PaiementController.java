package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.PaiementDto;
import org.reservation_backend.services.PaiementService;
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
@RequestMapping("api/paiement")
public class PaiementController {
	
	@Autowired
	private PaiementService paiementService;
	
   @PostMapping("/Paiement")
	public PaiementDto addPaiement(@RequestBody PaiementDto paiementDto) {
        return paiementService.addPaiement(paiementDto);
    }
  @PutMapping("/Paiement/{uuid}")
	    public PaiementDto updatePaiement(@RequestBody PaiementDto paiementDto, @PathVariable String uuid) {
	        return paiementService.updatePaiement(paiementDto, uuid);
	    }
  @GetMapping("/Paiement/{uuid}")
   public PaiementDto getPaiement(@PathVariable String uuid) {
	     return paiementService.getPaiement(uuid);
	 }
  @GetMapping("/Paiement")
  public List<PaiementDto> listePaiement() {
      return paiementService.listePaiement();
  }
  @DeleteMapping("/Paiement/{uuid}")
  public boolean deletePaiement(@PathVariable String uuid) {
      return paiementService.deletePaiement(uuid);
  }



}
