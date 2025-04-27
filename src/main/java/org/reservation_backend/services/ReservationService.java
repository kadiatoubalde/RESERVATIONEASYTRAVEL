package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.ReservationDto;


public interface ReservationService {
	
	ReservationDto addReservation(ReservationDto reservationDto);
    ReservationDto updateReservation(ReservationDto reservationDto,String uuid);
    ReservationDto getReservation(String uuid);
    List<ReservationDto> listeReservation();
    boolean deleteReservation(String uuid);
	 
	 

}
