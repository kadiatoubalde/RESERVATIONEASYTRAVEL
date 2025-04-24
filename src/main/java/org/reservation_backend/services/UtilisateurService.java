package org.reservation_backend.services;

import java.util.List;



import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurService {
	
	private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
 
      // Creer un utilisateur
    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    //   Recuperer tous les utilisateurs
    public List<Utilisateur> getTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

   
     //  Recuperer un utilsateur par son id
    public Utilisateur getUtilisateurParUuid(String uuid) {
        Utilisateur utilisateur = utilisateurRepository.findByUuid(uuid);
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur non trouvé : " + uuid);
        }
        return utilisateur;
    }
    
    // Mettre à jour un utilisateur
    public Utilisateur mettreAJourUtilisateur(String uuid, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé : " + uuid));

        if (utilisateurDetails.getPrenom() != null) {
            utilisateur.setPrenom(utilisateurDetails.getPrenom());
        }
        if (utilisateurDetails.getNom() != null) {
            utilisateur.setNom(utilisateurDetails.getNom());
        }
        if (utilisateurDetails.getTelephone() != null) {
            utilisateur.setTelephone(utilisateurDetails.getTelephone());
        }
        if (utilisateurDetails.getAdresse() != null) {
            utilisateur.setAdresse(utilisateurDetails.getAdresse());
        }

        return utilisateurRepository.save(utilisateur);
    }

     
    // Supprimer un utilisateur
    public void supprimerUtilisateur(String uuid) {
       
    	Utilisateur utilisateur = utilisateurRepository.findByUuid(uuid);
        if (utilisateur != null) {
            utilisateurRepository.deleteByUuid(uuid); 
        }
        else {
            throw new IllegalArgumentException("Utilisateur non trouvé : " + uuid);
        }
    }
   
   

}
