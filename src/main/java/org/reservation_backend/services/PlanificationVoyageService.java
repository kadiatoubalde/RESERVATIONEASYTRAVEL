package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.PlanificationVoyage;
import org.reservation_backend.repository.PlanificationVoyageRepository;

public class PlanificationVoyageService {
	private final PlanificationVoyageRepository planificationVoyageRepository;
	
	public PlanificationVoyageService(PlanificationVoyageRepository planificationVoyageRepository) {
        this.planificationVoyageRepository = planificationVoyageRepository;
    }
	
	public PlanificationVoyage creerPlanification(PlanificationVoyage planificationVoyage) {
        return planificationVoyageRepository.save(planificationVoyage);
    }
	
	public PlanificationVoyage getPlanificationParId(String uuid) {
        return planificationVoyageRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Planification non trouvée : " + uuid));
    }
	
	  public PlanificationVoyage mettreAJourPlanification(String uuid, PlanificationVoyage details) {
	        PlanificationVoyage planif = getPlanificationParId(uuid);

	        if (details.getHeureDepart() != null) planif.setHeureDepart(details.getHeureDepart());
	        if (details.getHeureArrivee() != null) planif.setHeureArrivee(details.getHeureArrivee());
	        if (details.getNombrePlaces() != 0) planif.setNombrePlaces(details.getNombrePlaces());
	        if (details.getNombrePlacesImage() != 0) planif.setNombrePlacesImage(details.getNombrePlacesImage());
	        if (details.getMontant() != 0.0) planif.setMontant(details.getMontant());
	        if (details.getTrajet() != null) planif.setTrajet(details.getTrajet());
	        if (details.getVehicule() != null) planif.setVehicule(details.getVehicule());
	        if (details.getUtilisateur() != null) planif.setUtilisateur(details.getUtilisateur());

	        return planificationVoyageRepository.save(planif);
	    }
	  
	 public void supprimerPlanification(String uuid) {
	        PlanificationVoyage planif = getPlanificationParId(uuid);
	        planificationVoyageRepository.delete(planif);
	    }
	 
	 public List<PlanificationVoyage> getToutesLesPlanifications() {
	        return planificationVoyageRepository.findAll();
	    }
}
