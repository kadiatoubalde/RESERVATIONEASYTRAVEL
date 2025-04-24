package org.reservation_backend.serviceImpl;

import org.reservation_backend.dto.ModePaiementDto;
import org.reservation_backend.services.ModePaiementService;

import java.util.List;

public class ModePaiementServiceImpl implements ModePaiementService {
    /**
     * @param modePaiementDto
     * @return
     */
    @Override
    public ModePaiementDto add(ModePaiementDto modePaiementDto) {
        return null;
    }

    /**
     * @param modePaiementDto
     * @param uuid
     * @return
     */
    @Override
    public ModePaiementDto update(ModePaiementDto modePaiementDto, String uuid) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<ModePaiementDto> listes() {
        return List.of();
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public ModePaiementDto get(String uuid) {
        return null;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public boolean delete(String uuid) {
        return false;
    }
}
