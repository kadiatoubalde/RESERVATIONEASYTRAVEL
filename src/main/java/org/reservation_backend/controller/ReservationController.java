package org.reservation_backend.controller;


import java.util.List;

import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api.reservation")
public class ReservationController {
	
@Autowired
private ReservationService reservationService;

@PostMapping("/reservation")
public ReservationDto addReservation(@RequestBody ReservationDto reservationDto) {
    return reservationService.addReservation(reservationDto);
}
@PutMapping("/reservation/{uuid}")
public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto, @PathVariable String uuid) {
    return reservationService.updateReservation(reservationDto, uuid);
}
@GetMapping("/reservation/{uuid}")
public ReservationDto getReservation(@PathVariable String uuid) {
    return reservationService.getReservation(uuid);
}
@GetMapping("/reservation")
public List<ReservationDto> listReservations() {
    return reservationService.listeReservation();
}
@DeleteMapping("/reservation/{uuid}")
public boolean deleteReservation(@PathVariable String uuid) {
    return reservationService.deleteReservation(uuid);
}

}
