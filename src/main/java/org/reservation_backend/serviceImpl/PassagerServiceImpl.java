package org.reservation_backend.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Passager;
import org.reservation_backend.repository.PassagerRepository;
import org.reservation_backend.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PassagerServiceImpl  implements PassagerService{
  
	@Autowired
    private PassagerRepository passagerRepository;
	@Override
	public PassagerDto addPassager(PassagerDto passagerDto) {
		Passager passager = Mapper.toEntityPassager(passagerDto);

        if (!passager.equals(new Passager())) {
            passager = passagerRepository.save(passager);
        }

        return Mapper.toDtoPassager(passager);

	}

	@Override
	public PassagerDto updatePassager(PassagerDto passagerDto, String uuid) {
		Passager passager = passagerRepository.findById(uuid).orElseThrow();
        passager = Mapper.toEntityPassager(passagerDto);

        if (!passager.equals(new Passager())) {
            passager = passagerRepository.save(passager);
        }

        return Mapper.toDtoPassager(passager);
	}
	@Override
	public PassagerDto getPassager(String uuid) {
		  Passager passager = passagerRepository.findById(uuid).orElseThrow();
	        return Mapper.toDtoPassager(passager);
	}
	@Override
	public List<PassagerDto> listePassager() {
		List<Passager> passagers = passagerRepository.listes();
	    List<PassagerDto> passagerDtos = new ArrayList<>();
	    passagers.forEach(passager -> passagerDtos.add(Mapper.toDtoPassager(passager)));
	    return passagerDtos;
	}
	@Override
	public boolean deletePassager(String uuid) {
		Passager passager = passagerRepository.findById(uuid).orElseThrow();
        if (!passager.isDelete()) {
            passager.setDelete(true);
            passagerRepository.save(passager);
        }
        return passager.isDelete();
	}
}
