package org.reservation_backend.dto;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.reservation_backend.dto.ReservationDto;
import org.reservation_backend.dto.PlanificationVoyageDto;


@Data
@NoArgsConstructor
public class PassagerDto {
	    private String uuid;
	    private  String  lastname;
	    private  String  firstname;
	    private  String  telephone;
		private int nombreBiillet;

	public PassagerDto(String uuid, String lastname, String firstname, String telephone, Long nombreBiillet) {
		this.uuid = uuid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.telephone = telephone;
		this.nombreBiillet = nombreBiillet != null ? nombreBiillet.intValue() : 0;
	}
}
