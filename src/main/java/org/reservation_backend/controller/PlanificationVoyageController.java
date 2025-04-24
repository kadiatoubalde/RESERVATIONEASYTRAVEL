package org.reservation_backend.controller;

import org.reservation_backend.dto.PlanificationVoyageDto;
import org.reservation_backend.serviceImpl.PlanificationVoyageServiceImpl;
import org.reservation_backend.services.PlanificationVoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PlanificationVoyageController {

    @Autowired
    private PlanificationVoyageService planificationVoyageService;

    @PostMapping("/planificationVoyage")
    public PlanificationVoyageDto addPlanification(@RequestBody  PlanificationVoyageDto planificationVoyageDto){
        return planificationVoyageService.addPlanification(planificationVoyageDto);
    }

    @PutMapping("/planificationVoyage/{uuid}")
    public PlanificationVoyageDto updatePlanification(@RequestBody PlanificationVoyageDto planificationVoyageDto, @PathVariable String uuid){
        return planificationVoyageService.updatePlanification(planificationVoyageDto,uuid);
    }
    @GetMapping("/planificationVoyage/{uuid}")
    public PlanificationVoyageDto getPlanification(@PathVariable String uuid){
        return planificationVoyageService.getPlanification(uuid);
    }

    @GetMapping("/planificationVoyage")
    public List<PlanificationVoyageDto> listePlanification(){
        return planificationVoyageService.listePlanification();
    }

    @DeleteMapping("/planificationVoyage/{uuid}")
    public boolean deletePlanification(@PathVariable String uuid){
        return planificationVoyageService.deletePlanification(uuid);
    }

}
