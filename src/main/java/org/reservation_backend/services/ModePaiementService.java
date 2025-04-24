package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.models.ModePaiement;
import org.reservation_backend.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;

@Service
public interface ModePaiementService {
   ModePaiementDto add(ModePaiementDto modePaiementDto);
   ModePaiementDto update(ModePaiementDto modePaiementDto,String uuid);
   List<ModePaiementDto> listes();
   ModePaiementDto get(String uuid);
   boolean delete(String uuid);
}
