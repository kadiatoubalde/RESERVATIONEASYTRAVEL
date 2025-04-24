package org.reservation_backend.serviceImpl;

import org.reservation_backend.dto.PlanificationVoyageDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.PlanificationVoyage;
import org.reservation_backend.models.Trajet;
import org.reservation_backend.models.Vehicule;
import org.reservation_backend.repository.PlanificationVoyageRepository;
import org.reservation_backend.repository.TrajetRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.reservation_backend.repository.VehiculeRepository;
import org.reservation_backend.services.PlanificationVoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanificationVoyageServiceImpl implements PlanificationVoyageService {
    @Autowired
    private PlanificationVoyageRepository planificationVoyageRepository;
    @Autowired
    private TrajetRepository trajetRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public PlanificationVoyageDto addPlanification(PlanificationVoyageDto planificationVoyageDto) {
        Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(planificationVoyageDto.getUuidVehicule());
        Optional<Trajet> trajetOptional = trajetRepository.findById(planificationVoyageDto.getUuidTrajet());
        PlanificationVoyage planificationVoyage = new PlanificationVoyage();
        planificationVoyage = Mapper.toEntityPlanificationVoyage(planificationVoyageDto);

        if(vehiculeOptional.isPresent()){
            planificationVoyage.setVehicule(vehiculeOptional.get());
        }

        if(trajetOptional.isPresent()){
            planificationVoyage.setTrajet(trajetOptional.get());
        }

        if(!planificationVoyage.equals(new PlanificationVoyage())){
            planificationVoyage = planificationVoyageRepository.save(planificationVoyage);
        }

        return Mapper.toDtoPlanificationVoyage(planificationVoyage);
    }

    @Override
    public PlanificationVoyageDto updatePlanification(PlanificationVoyageDto planificationVoyageDto, String uuid) {
        Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(planificationVoyageDto.getUuidVehicule());
        Optional<Trajet> trajetOptional = trajetRepository.findById(planificationVoyageDto.getUuidTrajet());
        PlanificationVoyage planificationVoyage = planificationVoyageRepository.findById(uuid).orElseThrow();
        planificationVoyage = Mapper.toEntityPlanificationVoyage(planificationVoyageDto);

        if(vehiculeOptional.isPresent()){
            planificationVoyage.setVehicule(vehiculeOptional.get());
        }

        if(trajetOptional.isPresent()){
            planificationVoyage.setTrajet(trajetOptional.get());
        }

        if(!planificationVoyage.equals(new PlanificationVoyage())){
            planificationVoyage = planificationVoyageRepository.save(planificationVoyage);
        }

        return Mapper.toDtoPlanificationVoyage(planificationVoyage);
    }

    @Override
    public PlanificationVoyageDto getPlanification(String uuid) {
        PlanificationVoyage planificationVoyage = planificationVoyageRepository.findById(uuid).orElseThrow();
        return Mapper.toDtoPlanificationVoyage(planificationVoyage);
    }

    @Override
    public List<PlanificationVoyageDto> listePlanification() {
        List<PlanificationVoyage> planificationVoyages = planificationVoyageRepository.listes();
        List<PlanificationVoyageDto> planificationVoyageDtos = new ArrayList<>();
        planificationVoyages.forEach(planificationVoyage -> planificationVoyageDtos.add(Mapper.toDtoPlanificationVoyage(planificationVoyage)));
        return planificationVoyageDtos;
    }

    @Override
    public boolean deletePlanification(String uuid) {
        PlanificationVoyage planificationVoyage = planificationVoyageRepository.findById(uuid).orElseThrow();
        if(!planificationVoyage.isDelete()){
            planificationVoyage.setDelete(true);
            planificationVoyageRepository.save(planificationVoyage);
        }
        return planificationVoyage.isDelete();
    }



}
