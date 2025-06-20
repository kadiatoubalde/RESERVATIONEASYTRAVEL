package org.reservation_backend.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.reservation_backend.dto.*;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Trajet;
import org.reservation_backend.serviceImpl.TrajetServiceImpl;
import org.reservation_backend.serviceImpl.UtilisateurService;
import org.reservation_backend.services.ReservationService;
import org.reservation_backend.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trajets")
public class TrajetController {
	
	@Autowired
	private TrajetService trajetService;
	private final UtilisateurService utilisateurService;
	private final ReservationService reservationService;

	public TrajetController(UtilisateurService utilisateurService, ReservationService reservationService) {
        this.utilisateurService = utilisateurService;
        this.reservationService = reservationService;
    }

    @PostMapping("")
	public ResponseEntity<TrajetDto> addTrajet(@RequestBody TrajetDto trajetDto) {
		TrajetDto createdTrajet = trajetService.addTrajet(trajetDto);
		return ResponseEntity.ok(createdTrajet);
	}
	
	@PutMapping("/{uuid}")
	public  ResponseEntity<TrajetDto> updateTrajet(@RequestBody TrajetDto trajetDto,@PathVariable String uuid) {
		TrajetDto updatedTrajet = trajetService.updateTrajet(trajetDto, uuid);
		return ResponseEntity.ok(updatedTrajet);
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<TrajetDto> getTrajet(@PathVariable String uuid) {
		TrajetDto trajet = Mapper.toDtoTrajet(trajetService.getTrajet(uuid));
		if(trajet != null) {
			return ResponseEntity.ok(trajet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	 @GetMapping("")
	 public  ResponseEntity<List<TrajetDto>> listeTrajet() {
		 List<TrajetDto> trajets = trajetService.listeTrajet();
		 return ResponseEntity.ok(trajets);
	 }
	 
	 @DeleteMapping("/{uuid}")
	 public ResponseEntity<Void> deleteTrajet(@PathVariable String uuid) {
		 boolean deleted = trajetService.deleteTrajet(uuid);
		 if(deleted) {
			 return ResponseEntity.noContent().build();
		 }else {
			 return ResponseEntity.notFound().build();
		 }	 
	 }

	@PostMapping("/{trajetId}/attribuer")
	public ResponseEntity<String> attribuerChauffeur(@PathVariable String trajetId, @RequestBody AttribuerChauffeurRequest chauffeurId) {
		return ResponseEntity.ok(
				trajetService.attribuer(trajetId,chauffeurId.getChauffeurId())
		);
	}
	@GetMapping("/search")
	public ResponseEntity<List<TrajetDto>> searchTrajets(
			@RequestParam(required = false) String departId,
			@RequestParam(required = false) String arriveId,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDepart,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime timeDepart
	) {
		SearchTrajetDto dto = SearchTrajetDto.builder()
				.departId(departId)
				.arriveId(arriveId)
				.dateDepart(dateDepart)
				.timeDepart(timeDepart)
				.build();

		List<Trajet> trajets = trajetService.rechercherTrajets(dto);
		List<TrajetDto> result = trajets.stream().map(Mapper::toDtoTrajet).toList();
		return ResponseEntity.ok(result);
	}

	@GetMapping("/chauffeur/mesTrajets")
	public ResponseEntity<List<TrajetDto>> getAllMyTrajets() {
		return ResponseEntity.ok().body(
				utilisateurService.getAllMyTrajets()
		);
	}
	@GetMapping("/chauffeur/mesPassager")
	public ResponseEntity<List<PassagerDto>> getPassagersPourChauffeur() {
		return ResponseEntity.ok(trajetService.getPassagerByTrajets());
	}

	@PutMapping("/changeStatus/{uuid}")
	public ResponseEntity<Boolean> changeStatus(@PathVariable String uuid, @RequestParam String status) {
		return ResponseEntity.ok(
				trajetService.changeStatus(uuid,status)
		);
	}
}
