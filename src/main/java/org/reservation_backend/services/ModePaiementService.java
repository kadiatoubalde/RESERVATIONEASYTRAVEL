package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.models.ModePaiement;
import org.reservation_backend.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;

@Service
public interface ModePaiementService {
   ModePaiementDto addModePaiement(ModePaiementDto modePaiementDto);
   ModePaiementDto updateModePaiement(ModePaiementDto modePaiementDto,String uuid);
   List<ModePaiementDto> listesModePaiement();
   ModePaiementDto getModePaiement(String uuid);
   boolean delete(String uuid);
}
