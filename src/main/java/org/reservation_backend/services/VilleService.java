package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Ville;
import org.reservation_backend.repository.VilleRepository;

public class VilleService {
 
	   private final VilleRepository villeRepository;
	
	   public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
	   }
        public Ville creerVille(Ville ville) {
            return villeRepository.save(ville);
        }

        public Ville getVilleParId(String uuid) {
            return villeRepository.findById(uuid)
                    .orElseThrow(() -> new IllegalArgumentException("Ville non trouvée : " + uuid));
        }

        public List<Ville> getToutesLesVilles() {
            return villeRepository.findAll();
        }

        public Ville mettreAJourVille(String uuid, Ville details) {
            Ville ville = villeRepository.findById(uuid)
                    .orElseThrow(() -> new IllegalArgumentException("Ville non trouvée : " + uuid));

            ville.setLibelle(details.getLibelle());

            return villeRepository.save(ville);
        }

        public void supprimerVille(String uuid) {
            Ville ville = villeRepository.findById(uuid)
                    .orElseThrow(() -> new IllegalArgumentException("Ville non trouvée : " + uuid));
            villeRepository.delete(ville);
    }


}
