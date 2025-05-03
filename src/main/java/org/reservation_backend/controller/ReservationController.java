package org.reservation_backend.controller;


import java.util.List;

import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {
	
@Autowired
private ReservationService reservationService;

@PostMapping("/ajouter")
public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationDto reservationDto) {
	ReservationDto createdReservation = reservationService.addReservation(reservationDto);
    return ResponseEntity.ok(createdReservation);
}
@PutMapping("/modifier/{uuid}")
public  ResponseEntity<ReservationDto >updateReservation(@RequestBody ReservationDto reservationDto, @PathVariable String uuid) {
	ReservationDto updatedReservation = reservationService.updateReservation(reservationDto, uuid);
    return ResponseEntity.ok(updatedReservation);
}
@GetMapping("/recuperer/{uuid}")
public  ResponseEntity<ReservationDto> getReservation(@PathVariable String uuid) {
	ReservationDto reservation = reservationService.getReservation(uuid);
	if(reservation != null) {
		return ResponseEntity.ok(reservation);
	} else {
		return ResponseEntity.notFound().build();
	}
  
}
@GetMapping("/lister")
public ResponseEntity<List<ReservationDto>> listReservations() {
	List<ReservationDto> reservations = reservationService.listeReservation();
    return ResponseEntity.ok(reservations);
}
@DeleteMapping("/supprimer/{uuid}")
public ResponseEntity<Void> deleteReservation(@PathVariable String uuid) {
	boolean deleted = reservationService.deleteReservation(uuid);
	if(deleted) {
		return ResponseEntity.noContent().build();
	} else {
		return ResponseEntity.notFound().build();
	}
}

}
