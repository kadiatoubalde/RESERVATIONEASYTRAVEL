package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Passager;
import org.reservation_backend.repository.PassagerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassagerService {
	
	 private final PassagerRepository passagerRepository;
	 
	 public PassagerService(PassagerRepository passagerRepository) {
	        this.passagerRepository = passagerRepository;
	    }
	 public Passager creerPassager(Passager passager) {
	        return passagerRepository.save(passager);
	    }
	 public Passager getPassagerParId(String uuid) {
	        return passagerRepository.findById(uuid)
	                .orElseThrow(() -> new IllegalArgumentException("Passager non trouvé : " + uuid));
	    }
	 public void supprimerPassager(String uuid) {
	        Passager passager = getPassagerParId(uuid);
	        passagerRepository.delete(passager);
	    }
	 public List<Passager> getTousLesPassagers() {
	        return passagerRepository.findAll();
	    }
	 public Passager mettreAJourPassager(String uuid, Passager passagerDetails) {
	        Passager passager = getPassagerParId(uuid);

	        if (passagerDetails.getNom() != null) passager.setNom(passagerDetails.getNom());
	        if (passagerDetails.getPrenom() != null) passager.setPrenom(passagerDetails.getPrenom());
	        if (passagerDetails.getAdresse() != null) passager.setAdresse(passagerDetails.getAdresse());
	        if (passagerDetails.getTelephone() != null) passager.setTelephone(passagerDetails.getTelephone());
	        if (passagerDetails.getTelephonePersonneContact() != null)
	            passager.setTelephonePersonneContact(passagerDetails.getTelephonePersonneContact());
	        if (passagerDetails.getAdressePersonneContact() != null)
	            passager.setAdressePersonneContact(passagerDetails.getAdressePersonneContact());
	        if (passagerDetails.getCivilite() != null) passager.setCivilite(passagerDetails.getCivilite());
	        if (passagerDetails.getGenre() != null) passager.setGenre(passagerDetails.getGenre());

	        return passagerRepository.save(passager);
	    }

}
