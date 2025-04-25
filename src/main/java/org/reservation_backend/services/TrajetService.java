package org.reservation_backend.services;

import java.util.List;
import org.reservation_backend.dto.TrajetDto;
import org.springframework.stereotype.Service;


@Service
public interface TrajetService {
 
	TrajetDto addTrajet(TrajetDto trajetDto);
	TrajetDto updateTrajet(TrajetDto trajetDto,String uuid);
	TrajetDto getTrajet(String uuid);
	List<TrajetDto> listeTrajet();
	boolean deleteTrajet(String uuid);
	
	 
	

}
