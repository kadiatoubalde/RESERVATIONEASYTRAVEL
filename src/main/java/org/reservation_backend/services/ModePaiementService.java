package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.ModePaiement;
import org.reservation_backend.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;

@Service
public class ModePaiementService {
    private final ModePaiementRepository modePaiementRepository;
    
    public ModePaiementService(ModePaiementRepository modePaiementRepository) {
        this.modePaiementRepository = modePaiementRepository;
    }
    public ModePaiement creerModePaiement(ModePaiement modePaiement) {
        return modePaiementRepository.save(modePaiement);
    }
    public ModePaiement getModePaiementParId(String uuid) {
        return modePaiementRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Mode de paiement non trouvé : " + uuid));
    }

    public List<ModePaiement> getTousLesModesPaiement() {
        return modePaiementRepository.findAll();
    }
    public ModePaiement mettreAJourModePaiement(String uuid, ModePaiement details) {
        ModePaiement modePaiement = modePaiementRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Mode de paiement non trouvé : " + uuid));

        modePaiement.setLibelle(details.getLibelle());
        modePaiement.setDescription(details.getDescription());

        return modePaiementRepository.save(modePaiement);
    }
    public void supprimerModePaiement(String uuid) {
        ModePaiement modePaiement = modePaiementRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Mode de paiement non trouvé : " + uuid));
        modePaiementRepository.delete(modePaiement);
    }
}
