package org.reservation_backend.mapper;


import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.dto.PaiementDto;
import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.dto.PlanificationVoyageDto;
import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.TrajetDto;
import org.reservation_backend.dto.UtilisateurDto;
import org.reservation_backend.dto.VehiculeDto;
import org.reservation_backend.dto.VilleDto;
import org.reservation_backend.models.*;

import java.util.List;

public class Mapper {
	
	
	public static TrajetDto toDtoTrajet(Trajet trajet) {
		TrajetDto trajetDto = new TrajetDto();
		trajetDto.setUuid(trajet.getUuid());
		trajetDto.setPointDepart(trajet.getPointDepart().getLibelle());
		trajetDto.setPointArriver(trajet.getPointArrive().getLibelle());
		trajetDto.setUuidPointArriver(trajet.getPointArrive().getUuid());
		trajetDto.setUuidPointDepart(trajet.getPointDepart().getUuid());
		return trajetDto;
	}
	
	public static Trajet toEntityTrajet(TrajetDto trajetDto) {
		Trajet trajet = new Trajet();
		trajet.setPointDepart(trajet.getPointDepart());
		trajet.setPointArrive(trajet.getPointArrive());
		return trajet;
	}



	public  static PlanificationVoyageDto toDtoPlanificationVoyage(PlanificationVoyage  planificationVoyage){
		PlanificationVoyageDto planificationVoyageDto= new PlanificationVoyageDto();
		    planificationVoyageDto.setUuid(planificationVoyage.getUuid());
		    planificationVoyageDto.setHeureDepart(planificationVoyage.getHeureDepart());
		    planificationVoyageDto.setHeureArrivee(planificationVoyage.getHeureArrivee());
		    planificationVoyageDto.setNombrePlaces(planificationVoyage.getNombrePlaces());
		    planificationVoyageDto.setNombrePlacesImage(planificationVoyage.getNombrePlacesImage());
		    planificationVoyageDto.setMontant(planificationVoyage.getMontant());
		    planificationVoyageDto.setUuidTrajet(planificationVoyage.getTrajet().getPointDepart().getLibelle());
		    planificationVoyageDto.setUuidTrajet(planificationVoyage.getTrajet().getPointArrive().getLibelle());
		    planificationVoyageDto.setUuidVehicule(planificationVoyage.getVehicule().getUuid());
		    planificationVoyageDto.setUuidUtilisateur(planificationVoyage.getUtilisateur().getUuid());
			return  planificationVoyageDto;
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
  public static Passager toEntityPassager(PassagerDto PassagerDto) {
		Passager passager = new Passager();
		passager.setUuid(passager.getUuid());
		passager.setNom(passager.getNom());
		passager.setPrenom(passager.getPrenom());
		passager.setAdresse(passager.getAdresse());
		passager.setTelephone(passager.getTelephone());
		passager.setTelephonePersonneContact(passager.getTelephonePersonneContact());
		passager.setAdressePersonneContact(passager.getAdressePersonneContact());
		passager.setCivilite(passager.getCivilite());
		passager.setGenre(passager.getGenre());
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
		paiementDto.setUuiUtilisateur(paiement.getUtilisateur().getUuid());
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
		reservationDto.setUuidPaiement(reservation.getPaiement().getUuid());
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
   public  static UtilisateurDto toDtoUtilisateur(Utilisateur utilisateur) {
	   UtilisateurDto utilisateurDto= new 	UtilisateurDto();
	   utilisateurDto.setUuid(utilisateur.getUuid());
	   utilisateurDto.setPrenom(utilisateur.getPrenom());
	   utilisateurDto.setNom(utilisateur.getNom());
	   utilisateurDto.setAdresse(utilisateur.getAdresse());
	   utilisateurDto.setTelephone(utilisateur.getTelephone());
		return  utilisateurDto;
   }
   public  static  Utilisateur toEntityUtilisateur(UtilisateurDto utilisateurDto) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom(utilisateur.getPrenom());
		utilisateur.setNom(utilisateur.getNom());
		utilisateur.setAdresse(utilisateur.getAdresse());
		utilisateur.setTelephone(utilisateur.getTelephone());
		return utilisateur;
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
   public static  Vehicule toEntity(VehiculeDto vehiculeDto) {
		Vehicule vehicule = new Vehicule();
		vehicule.setMarque(vehicule.getMarque());
		vehicule.setImmatriculation(vehicule.getImmatriculation());
		vehicule.setDescription(vehicule.getDescription());
		vehicule.setEnumTypeVehicule(vehicule.getEnumTypeVehicule());
		vehicule.setNombrePlace(vehicule.getNombrePlace());
		vehicule.setModele(vehicule.getModele());
		return vehicule;
	}
	public static  VilleDto toDtoVille(Ville ville){
		  VilleDto   villeDto= new VilleDto();
		  villeDto.setUuid(ville.getUuid());
		  villeDto.setLibelle(ville.getLibelle());
		return  villeDto;
	}
	public  static  Ville toEntity(VilleDto villeDto) {
		Ville ville = new Ville();
		ville.setUuid(ville.getUuid());
		ville.setLibelle(ville.getLibelle());
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
		modePaiement.setLibelle(modePaiement.getLibelle());
		modePaiement.setDescription(modePaiement.getDescription());
		return modePaiement ;
	}
  }
