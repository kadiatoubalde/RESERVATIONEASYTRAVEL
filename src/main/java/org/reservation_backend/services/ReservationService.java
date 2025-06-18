package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.ReservationDtoResponse;


public interface ReservationService {
    ReservationDtoResponse reserverTrajet(ReservationDto reservationDto);

    List<ReservationDtoResponse> mesReservations();
}
