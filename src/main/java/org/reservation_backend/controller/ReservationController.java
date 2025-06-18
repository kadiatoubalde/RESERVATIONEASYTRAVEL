package org.reservation_backend.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.ReservationDtoResponse;
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
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    public ResponseEntity<ReservationDtoResponse> reserver(@RequestBody ReservationDto reservationDto) {
        ReservationDtoResponse response = reservationService.reserverTrajet(reservationDto);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/mesReservations")
    public ResponseEntity<List<ReservationDtoResponse>> mesReservations(){
        return ResponseEntity.ok(
                reservationService.mesReservations()
        );
    }
}
