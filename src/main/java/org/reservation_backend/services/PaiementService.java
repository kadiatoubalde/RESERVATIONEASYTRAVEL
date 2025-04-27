package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.PaiementDto;
import org.springframework.stereotype.Service;

@Service
public interface PaiementService {
	
	PaiementDto addPaiement(PaiementDto paiementDto) ;
	PaiementDto updatePaiement(PaiementDto paiementDto,String uuid);
	PaiementDto getPaiement(String uuid);
	List<PaiementDto> listePaiement();
	boolean deletePaiement(String uui);

}
