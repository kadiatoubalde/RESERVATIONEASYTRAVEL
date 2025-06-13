package org.reservation_backend.serviceImpl;

import org.reservation_backend.Enum.EnumRoleUtilisateur;
import org.reservation_backend.Enum.StatutTrajet;
import org.reservation_backend.dto.SearchTrajetDto;
import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Trajet;
import org.reservation_backend.models.TrajetSpecification;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.models.Ville;
import org.reservation_backend.repository.TrajetRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.reservation_backend.repository.VilleRepository;
import org.reservation_backend.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetServiceImpl  implements TrajetService{
	
    @Autowired
	private TrajetRepository trajetRepository;
    @Autowired
    private VilleRepository villeRepository;
	private  Mapper mapper;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	public TrajetServiceImpl(Mapper mapper) {
		this.mapper = mapper;
	}

    /**
	 * @param trajetDto
	 * @return
	 */
	@Override
	public TrajetDto addTrajet(TrajetDto trajetDto) {
		// Récupération des villes liées au trajet
		Ville villeDepart = villeRepository.findById(trajetDto.getUuidPointDepart())
				.orElseThrow(() -> new RuntimeException("Ville de départ introuvable avec l'UUID : " + trajetDto.getUuidPointDepart()));

		Ville villeArrive = villeRepository.findById(trajetDto.getUuidPointArriver())
				.orElseThrow(() -> new RuntimeException("Ville d’arrivée introuvable avec l'UUID : " + trajetDto.getUuidPointArriver()));

		// Construction de l'entité trajet avec les villes
		Trajet trajet = mapper.toEntityTrajet(trajetDto);
		trajet.setPointArrive(villeArrive);
		trajet.setPointDepart(villeDepart);
		// Sauvegarde dans la base
		Trajet saved = trajetRepository.save(trajet);

		// Conversion en DTO pour la réponse
		return Mapper.toDtoTrajet(saved);
	}

	/**
	 * @param trajetDto
	 * @param uuid
	 * @return
	 */
	@Override
	public TrajetDto updateTrajet(TrajetDto trajetDto, String uuid) {
		// On récupère le trajet existant
		Trajet existingTrajet = trajetRepository.findById(uuid)
				.orElseThrow(() -> new RuntimeException("Trajet non trouvé avec l'UUID : " + uuid));

		// On récupère les villes (point de départ et d'arrivée)
		Ville villeDepart = villeRepository.findById(trajetDto.getUuidPointDepart())
				.orElseThrow(() -> new RuntimeException("Ville de départ non trouvée"));
		Ville villeArrivee = villeRepository.findById(trajetDto.getUuidPointArriver())
				.orElseThrow(() -> new RuntimeException("Ville d'arrivée non trouvée"));

		// Mise à jour des champs du trajet existant
		existingTrajet.setPointDepart(villeDepart);
		existingTrajet.setPointArrive(villeArrivee);
		existingTrajet.setMontant(trajetDto.getMontant());

		// Enregistrement du trajet mis à jour
		Trajet savedTrajet = trajetRepository.save(existingTrajet);

		// Retour du DTO
		return Mapper.toDtoTrajet(savedTrajet);
	}


	@Override
	public Trajet getTrajet(String id) {
		return trajetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aucun trajet trouvé avec l’ID : " + id));
	}


	/**
	 * @return
	 */
	@Override
	public List<TrajetDto> listeTrajet() {
		List<Trajet> trajets = trajetRepository.findAll();
		List<TrajetDto> trajetDtos = new  ArrayList();
		trajets.forEach(trajet -> trajetDtos.add(Mapper.toDtoTrajet(trajet)));
		return trajetDtos;
	}

	/**
	 * @param uuid
	 * @return
	 */
	@Override
	public boolean deleteTrajet(String uuid) {
		Trajet trajet = trajetRepository.findById(uuid).orElseThrow();
		trajetRepository.delete(trajet);
		return true;
	}

	@Override
	public String attribuer(String trajetId, String chauffeurId) {
		System.out.println(trajetId + " "+ chauffeurId);
		Trajet trajet = trajetRepository.findById(trajetId).orElseThrow(()->new RuntimeException("Trajet non trouv<UNK>"));
		Utilisateur chauffeur = utilisateurRepository.findByUuidAndRole(chauffeurId, EnumRoleUtilisateur.CHAUFFEUR)
				.orElseThrow(()->new RuntimeException("Utilisateur non trouv<UNK>"));
		trajet.setChauffeur(chauffeur);
		trajetRepository.save(trajet);
		return "trajet attribué";
	}

	public List<Trajet> rechercherTrajets(SearchTrajetDto dto) {
		return trajetRepository.findAll(TrajetSpecification.withPrioritizedSearch(dto));
	}

	@Override
	public boolean changeStatus(String uuid, String status) {
		try{
			Trajet trajet = trajetRepository.findById(uuid).orElseThrow(()->new RuntimeException("Trajet non trouv<UNK>"));
			trajet.setStatus(StatutTrajet.valueOf(status));
			trajetRepository.save(trajet);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
