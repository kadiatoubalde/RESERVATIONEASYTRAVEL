package org.reservation_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchTrajetDto {
    private String departId;
    private String arriveId;
    private LocalDate dateDepart;
    private LocalTime timeDepart;
}
