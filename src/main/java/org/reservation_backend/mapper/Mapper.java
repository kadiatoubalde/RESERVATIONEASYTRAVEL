package org.reservation_backend.mapper;


import org.reservation_backend.Enum.EnumRoleUtilisateur;
import org.reservation_backend.dto.*;
import org.reservation_backend.models.*;
import org.reservation_backend.services.VilleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class Mapper {

	private final VilleService villeService;

    public Mapper(VilleService villeService) {
        this.villeService = villeService;
    }

    public static TrajetDto toDtoTrajet(Trajet trajet) {
		TrajetDto trajetDto = new TrajetDto();
		trajetDto.setUuid(trajet.getUuid());
		trajetDto.setPointDepart(trajet.getPointDepart().getLibelle());
		trajetDto.setPointArriver(trajet.getPointArrive().getLibelle());
		trajetDto.setUuidPointArriver(trajet.getPointArrive().getUuid());
		trajetDto.setUuidPointDepart(trajet.getPointDepart().getUuid());
		trajetDto.setMontant(trajet.getMontant());
		trajetDto.setDateDepart(trajet.getDateDepart());
		trajetDto.setTimeDepart(trajet.getTimeDepart());
		Optional.ofNullable(trajet.getChauffeur())
				.map(Utilisateur::getUuid)
				.ifPresent(trajetDto::setChauffeurId);

		return trajetDto;
	}

	public  Trajet toEntityTrajet(TrajetDto trajetDto) {
		Trajet trajet = new Trajet();
		trajet.setUuid(trajetDto.getUuid());
		trajet.setMontant(trajetDto.getMontant());
		trajet.setDateDepart(trajetDto.getDateDepart());
		trajet.setTimeDepart(trajetDto.getTimeDepart());
		// Récupération des entités Point de départ et d’arrivée à partir de leur UUID
		Ville pointDepart = villeService.findByUuid(trajetDto.getUuidPointDepart());
		Ville pointArrive =villeService.findByUuid(trajetDto.getUuidPointArriver());
		trajet.setPointDepart(pointDepart);
		trajet.setPointArrive(pointArrive);

		return trajet;
	}

	//  la conversion de la planification en dto
	public static PlanificationVoyageDto toDtoPlanificationVoyage(PlanificationVoyage planificationVoyage) {
		PlanificationVoyageDto dto = new PlanificationVoyageDto();
		dto.setUuid(planificationVoyage.getUuid());
		dto.setHeureDepart(planificationVoyage.getHeureDepart());
		dto.setHeureArrivee(planificationVoyage.getHeureArrivee());
		dto.setNombrePlaces(planificationVoyage.getNombrePlaces());
		dto.setNombrePlacesImage(planificationVoyage.getNombrePlacesImage());
		dto.setMontant(planificationVoyage.getMontant());

		if (planificationVoyage.getTrajet() != null) {
			dto.setUuidTrajet(planificationVoyage.getTrajet().getUuid());
		}

		if (planificationVoyage.getVehicule() != null) {
			dto.setUuidVehicule(planificationVoyage.getVehicule().getUuid());
		}

		if (planificationVoyage.getUtilisateur() != null) {
			dto.setUuidUtilisateur(planificationVoyage.getUtilisateur().getUuid());
		}

		return dto;
	}

	public  static PlanificationVoyage toEntityPlanificationVoyage(PlanificationVoyageDto planificationVoyageDto)	{
		PlanificationVoyage planificationVoyage = new PlanificationVoyage();
		planificationVoyage.setUuid(planificationVoyage.getUuid());
		planificationVoyage.setHeureDepart(planificationVoyage.getHeureDepart());
		planificationVoyage.setHeureArrivee(planificationVoyage.getHeureArrivee());
		planificationVoyage.setNombrePlaces(planificationVoyage.getNombrePlaces());
		planificationVoyage.setNombrePlacesImage(planificationVoyage.getNombrePlacesImage());
		planificationVoyage.setMontant(planificationVoyage.getMontant());
		return planificationVoyage;
	}
	
	public  static PassagerDto toDtoPassager(Passager passager) {
		PassagerDto passagerDto = new PassagerDto();
		passagerDto.setUuid(passager.getUuid());
		passagerDto.setNom(passager.getNom());
		passagerDto.setPrenom(passager.getPrenom());
		passagerDto.setAdresse(passager.getAdresse());
		passagerDto.setTelephone(passager.getTelephone());
		passagerDto.setTelephonePersonneContact(passager.getTelephonePersonneContact());
		passagerDto.setAdressePersonneContact(passager.getAdressePersonneContact());
		passagerDto.setCivilite(passager.getCivilite());
		passagerDto.setGenre(passager.getGenre());
		return passagerDto;
	}
  public static Passager toEntityPassager(PassagerDto passagerDto) {
		Passager passager = new Passager();
		passager.setUuid(passagerDto.getUuid());
	    passager.setNom(passagerDto.getNom());
	    passager.setPrenom(passagerDto.getPrenom());
	    passager.setAdresse(passagerDto.getAdresse());
	    passager.setTelephone(passagerDto.getTelephone());
	    passager.setTelephonePersonneContact(passagerDto.getTelephonePersonneContact());
	    passager.setAdressePersonneContact(passagerDto.getAdressePersonneContact());
	    passager.setCivilite(passagerDto.getCivilite());
	    passager.setGenre(passagerDto.getGenre());
	    return passager;
       }
  
  
  public  static PaiementDto toDtoPaiement(Paiement paiement) {
		PaiementDto paiementDto= new PaiementDto();
		paiementDto.setUuid(paiement.getUuid());
		paiementDto.setNumeroPaiement(paiement.getNumeroPaiement());
		paiementDto.setMontant(paiement.getMontant());
		paiementDto.setDatePaiement(paiement.getDatePaiement());
		paiementDto.setUuidModePaiement(paiement.getModePaiement().getUuid());;
		paiementDto.setUuidReservation(paiement.getReservation().getUuid());
		paiementDto.setUuidUtilisateur(paiement.getUtilisateur().getUuid());
		return paiementDto;
  }
  
  
  public  static Paiement toEntityPaiement(PaiementDto paiementDto) {
	  Paiement  paiement = new Paiement();
	  paiement.setNumeroPaiement(paiement.getNumeroPaiement());
	  paiement.setMontant(paiement.getMontant());
	  paiement.setDatePaiement(paiement.getDatePaiement());
	  return paiement;

  }
  
   public  static ReservationDto toDtoReservation(Reservation reservation) {
		ReservationDto 	reservationDto  = new ReservationDto();
		reservationDto.setUuid(reservation.getUuid());
		reservationDto.setDate(reservation.getDate());
		reservationDto.setStatut(reservation.getStatut());
		reservationDto.setNombreBagage(reservation.getNombreBagage());
		reservationDto.setNumeroReservation(reservation.getNumeroReservation());
		reservationDto.setUuidPassager(reservation.getPassager().getUuid());
		reservationDto.setUuidUtilisateur(reservation.getUtilisateur().getUuid());
		return reservationDto;
   }
   public static Reservation toEntityReservation(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		reservation.setUuid(reservation.getUuid());
		reservation.setDate(reservation.getDate());
		reservation.setStatut(reservation.getStatut());
		reservation.setNombreBagage(reservation.getNombreBagage());
		return  reservation;
   }

   public  static VehiculeDto toDtoVehicule(Vehicule vehicule) {
	     VehiculeDto  vehiculeDto = new  VehiculeDto();
	     vehiculeDto.setUuid(vehicule.getUuid());
	     vehiculeDto.setMarque(vehicule.getMarque());
	     vehiculeDto.setImmatriculation(vehicule.getImmatriculation());
	     vehiculeDto.setDescription(vehicule.getDescription());
	     vehiculeDto.setEnumTypeVehicule(vehicule.getEnumTypeVehicule());
	     vehiculeDto.setNombrePlace(vehicule.getNombrePlace());
	     vehiculeDto.setModele(vehicule.getModele());
		return vehiculeDto;
   }
   public static  Vehicule toEntityVehicule(VehiculeDto vehiculeDto) {
		Vehicule vehicule = new Vehicule();
		vehicule.setMarque(vehiculeDto.getMarque());
		vehicule.setImmatriculation(vehiculeDto.getImmatriculation());
		vehicule.setDescription(vehiculeDto.getDescription());
		vehicule.setEnumTypeVehicule(vehiculeDto.getEnumTypeVehicule());
		vehicule.setNombrePlace(vehiculeDto.getNombrePlace());
		vehicule.setModele(vehiculeDto.getModele());
		return vehicule;
	}
	public static  VilleDto toDtoVille(Ville ville){
		  VilleDto   villeDto= new VilleDto();
		  villeDto.setUuid(ville.getUuid());
		  villeDto.setNom(ville.getLibelle());
		return  villeDto;
	}
	public  static  Ville toEntityVille(VilleDto villeDto) {
		Ville ville = new Ville();
		ville.setUuid(villeDto.getUuid());
		ville.setLibelle(villeDto.getNom());
		return ville;
	}
	public  static ModePaiementDto toDtoModePaiement(ModePaiement modePaiement) {
		 ModePaiementDto  modePaiementDto = new ModePaiementDto();
		 modePaiementDto.setUuid(modePaiement.getUuid());
		 modePaiementDto.setLibelle(modePaiement.getLibelle());
		 modePaiementDto.setDescription(modePaiement.getDescription());
		 return modePaiementDto;
		 
	}
	public static ModePaiement toEntityModePaiement(ModePaiementDto modePaiementDto) {
		ModePaiement modePaiement = new ModePaiement();
		modePaiement.setLibelle(modePaiementDto.getLibelle());
		modePaiement.setDescription(modePaiementDto.getDescription());
		return modePaiement ;
	}

	public static RoleDto toRoleDto(Role role){
		RoleDto dto = new RoleDto();
		dto.setCode(role.getCode());
		dto.setLabel(role.getLabel());
		dto.setUuid(role.getUuid());
		return dto;
	}

	public static UtilisateurDto toUtilisateurDto(Utilisateur utilisateur){
		UtilisateurDto dto = new UtilisateurDto();
		dto.setUuid(utilisateur.getUuid());
		dto.setEmail(utilisateur.getEmail());
		dto.setFirstname(utilisateur.getFirstname());
		dto.setLastname(utilisateur.getLastname());
		dto.setPassword(utilisateur.getPassword());
		dto.setTelephone(utilisateur.getTelephone());
		dto.setRole(utilisateur.getRole().name());
		return dto;
	}

	public static List<UtilisateurDto> toUtilisateurDtoList(List<Utilisateur> clients) {
		if (clients == null || clients.isEmpty()) {
			return List.of();
		}

		return clients.stream()
				.map(Mapper::toUtilisateurDto)
				.collect(Collectors.toList());
	}


	public static Utilisateur toUtilisateur(UtilisateurDto utilisateurDto){
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setFirstname(utilisateurDto.getFirstname());
		utilisateur.setLastname(utilisateurDto.getLastname());
		utilisateur.setTelephone(utilisateurDto.getTelephone());
		utilisateur.setRole(EnumRoleUtilisateur.valueOf(utilisateurDto.getRole()));
		return utilisateur;
	}

	public static Role toRole(RoleDto roleDto){
		Role role = new Role();
		role.setLabel(roleDto.getLabel());
		role.setCode(roleDto.getCode());
		return role;
	}
  }
