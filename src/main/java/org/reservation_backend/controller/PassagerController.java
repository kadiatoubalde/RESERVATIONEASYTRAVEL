package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/passager")
public class PassagerController {
	@Autowired
    private PassagerService passagerService;
	
	 @PostMapping("/Passager")
	    public PassagerDto addPassager(@RequestBody PassagerDto passagerDto) {
	        return passagerService.addPassager(passagerDto);
	    }
	 @PutMapping("/Passager/{uuid}")
	    public PassagerDto updatePassager(@RequestBody PassagerDto passagerDto, @PathVariable String uuid) {
	        return passagerService.updatePassager(passagerDto, uuid);
	    }
	 @GetMapping("/Passager/{uuid}")
	    public PassagerDto getPassager(@PathVariable String uuid) {
	        return passagerService.getPassager(uuid);
	    }
	 @GetMapping("/Passager")
	    public List<PassagerDto> listePassager() {
	        return passagerService.listePassager();
	    }
	 @DeleteMapping("/Passager/{uuid}")
	    public boolean deletePassager(@PathVariable String uuid) {
	        return passagerService.deletePassager(uuid);
	    }
}
