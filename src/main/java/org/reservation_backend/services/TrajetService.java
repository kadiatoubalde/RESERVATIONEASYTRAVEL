package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Trajet;
import org.reservation_backend.models.Ville;
import org.reservation_backend.repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajetService {
	
	 private final TrajetRepository trajetRepository;
	 @Autowired
	 public TrajetService(TrajetRepository trajetRepository) {
	        this.trajetRepository = trajetRepository;
	    }
	 
	 public Trajet creerTrajet(Trajet trajet) {
	        return trajetRepository.save(trajet);
	    }
	 public List<Trajet> getTousLesTrajets() {
	        return trajetRepository.findAll();
	    }
	 
	 public Trajet getTrajetParUuid(String uuid) {
	        return trajetRepository.findById(uuid)
	        .orElseThrow(() -> new IllegalArgumentException("Trajet non trouvé : " + uuid));
	    }
	 
	 public Trajet mettreAJourTrajet(String uuid, Trajet trajetDetails) {
		    Trajet trajet = trajetRepository.findById(uuid)
		            .orElseThrow(() -> new IllegalArgumentException("Trajet non trouvé : " + uuid));

		    if (trajetDetails.getPointDepart() != null) {
		        trajet.setPointDepart(trajetDetails.getPointDepart());
		    }

		    if (trajetDetails.getPointArrive() != null) {
		        trajet.setPointArrive(trajetDetails.getPointArrive());
		    }

		    return trajetRepository.save(trajet);
		}
	 
	 public void supprimerTrajet(String uuid) {
	        Trajet trajet = trajetRepository.findById(uuid)
	        .orElseThrow(() -> new IllegalArgumentException("Trajet non trouvé : " + uuid));
	        trajetRepository.delete(trajet);
	    }
	 
	 public List<Trajet> getTrajetsParPointDepart(Ville pointDepart) {
		    return trajetRepository.findByPointDepart(pointDepart);
		}
	 public List<Trajet> getTrajetsParPointArrive(Ville pointArrive) {
		    return trajetRepository.findByPointArrive(pointArrive);
		}
	 
}
