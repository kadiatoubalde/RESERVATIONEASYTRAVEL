package org.reservation_backend.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReservationDtoResponse {
            LocalDateTime date;
            String statut;
            int nombreBagage;
            String numeroReservation;
            String Uuid;
}
