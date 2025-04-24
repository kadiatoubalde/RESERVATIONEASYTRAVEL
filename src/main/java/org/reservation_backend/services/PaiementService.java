package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Paiement;
import org.reservation_backend.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementService {
	
	private final PaiementRepository paiementRepository;
    @Autowired
	public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }
	
	public Paiement getPaiementParId(String uuid) {
        return paiementRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Paiement non trouvé : " + uuid));
    }
	
	 public List<Paiement> getTousLesPaiements() {
	        return paiementRepository.findAll();
	    }
	 
	 public Paiement creerPaiement(Paiement paiement) {
	        return paiementRepository.save(paiement);
	    }
	 public Paiement mettreAJourPaiement(String uuid, Paiement paiementDetails) {
	        Paiement paiement = paiementRepository.findById(uuid)
	                .orElseThrow(() -> new IllegalArgumentException("Paiement non trouvé : " + uuid));
	        
	        paiement.setNumeroPaiement(paiementDetails.getNumeroPaiement());
	        paiement.setDatePaiement(paiementDetails.getDatePaiement());
	        paiement.setMontant(paiementDetails.getMontant());
	        paiement.setModePaiement(paiementDetails.getModePaiement());
	        paiement.setReservation(paiementDetails.getReservation());
	        paiement.setUtilisateur(paiementDetails.getUtilisateur());
	        return paiementRepository.save(paiement);
	 }
	        
	        public void supprimerPaiement(String uuid) {
	            Paiement paiement = paiementRepository.findById(uuid)
	                    .orElseThrow(() -> new IllegalArgumentException("Paiement non trouvé : " + uuid));
	            paiementRepository.delete(paiement);
	        }


	

}
