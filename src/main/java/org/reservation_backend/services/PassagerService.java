package org.reservation_backend.services;

import java.util.List;

import org.reservation_backend.dto.PassagerDto;



public interface PassagerService {
	PassagerDto addPassager(PassagerDto passagerDto);
    PassagerDto updatePassager(PassagerDto passagerDto, String uuid);
    PassagerDto getPassager(String uuid);
    List<PassagerDto> listePassager();
    boolean deletePassager(String uuid);
	
}
