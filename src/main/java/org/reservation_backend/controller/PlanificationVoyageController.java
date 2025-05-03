package org.reservation_backend.controller;

import org.reservation_backend.dto.PlanificationVoyageDto;
import org.reservation_backend.serviceImpl.PlanificationVoyageServiceImpl;
import org.reservation_backend.services.PlanificationVoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/planificationVoyage")
public class PlanificationVoyageController {

    @Autowired
    private PlanificationVoyageService planificationVoyageService;

    @PostMapping("/ajouter")
    public ResponseEntity<PlanificationVoyageDto> addPlanification(@RequestBody  PlanificationVoyageDto planificationVoyageDto){
    	PlanificationVoyageDto created = planificationVoyageService.addPlanification(planificationVoyageDto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/modifier/{uuid}")
    public ResponseEntity<PlanificationVoyageDto> updatePlanification(@RequestBody PlanificationVoyageDto planificationVoyageDto, @PathVariable String uuid){
    	PlanificationVoyageDto updated = planificationVoyageService.updatePlanification(planificationVoyageDto, uuid);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/obtenir/{uuid}")
    public  ResponseEntity<PlanificationVoyageDto> getPlanification(@PathVariable String uuid){
    	PlanificationVoyageDto planification = planificationVoyageService.getPlanification(uuid);
    	if(planification != null) {
    		return ResponseEntity.ok(planification);
    	} else
    	{
    		return ResponseEntity.notFound().build();    
    	}
    }

    @GetMapping("/lister")
    public  ResponseEntity<List<PlanificationVoyageDto>> listePlanification(){
    	List<PlanificationVoyageDto> liste = planificationVoyageService.listePlanification();
    	return ResponseEntity.ok(liste);
    }

    @DeleteMapping("/supprimer/{uuid}")
    public  ResponseEntity<Void> deletePlanification(@PathVariable String uuid){
    	boolean deleted = planificationVoyageService.deletePlanification(uuid);
    	if(deleted) {
    		return ResponseEntity.noContent().build();
    	 } else 
    		{
    			return ResponseEntity.notFound().build();    		}
        
    }
}
