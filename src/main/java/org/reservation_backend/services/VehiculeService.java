package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.models.Vehicule;
import org.reservation_backend.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculeService {
	private final VehiculeRepository vehiculeRepository;

	public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
	public Vehicule creerVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
	public Vehicule getVehiculeParId(String uuid) {
        return vehiculeRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule non trouvé : " + uuid));
    }
	public List<Vehicule> getTousLesVehicules() {
        return vehiculeRepository.findAll();
    }
    
    public Vehicule mettreAJourVehicule(String uuid, Vehicule vehiculeDetails) {
        Vehicule vehicule = vehiculeRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule non trouvé : " + uuid));

        vehicule.setMarque(vehiculeDetails.getMarque());
        vehicule.setImmatriculation(vehiculeDetails.getImmatriculation());
        vehicule.setDescription(vehiculeDetails.getDescription());
        vehicule.setEnumTypeVehicule(vehiculeDetails.getEnumTypeVehicule());
        vehicule.setNombrePlace(vehiculeDetails.getNombrePlace());
        vehicule.setModele(vehiculeDetails.getModele());

        return vehiculeRepository.save(vehicule);
    }
    public void supprimerVehicule(String uuid) {
        Vehicule vehicule = vehiculeRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule non trouvé : " + uuid));
        vehiculeRepository.delete(vehicule);
    }

}
