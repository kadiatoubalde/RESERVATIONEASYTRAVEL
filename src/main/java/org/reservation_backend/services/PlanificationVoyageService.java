package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.PlanificationVoyageDto;
import org.reservation_backend.models.PlanificationVoyage;
import org.reservation_backend.repository.PlanificationVoyageRepository;

public interface PlanificationVoyageService {

	PlanificationVoyageDto addPlanification(PlanificationVoyageDto planificationVoyageDto);
	PlanificationVoyageDto updatePlanification(PlanificationVoyageDto planificationVoyageDto,String uuid);
	PlanificationVoyageDto getPlanification(String uuid);
	List<PlanificationVoyageDto>  listePlanification();
	boolean deletePlanification(String uuid);


}
