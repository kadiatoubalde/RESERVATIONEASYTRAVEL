package org.reservation_backend.controller;

import java.util.List;

import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.services.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api")
public class PassagerController {
	@Autowired
    private PassagerService passagerService;
	
	 @PostMapping("/passager")
	    public ResponseEntity<PassagerDto> addPassager(@RequestBody PassagerDto passagerDto) {
		 PassagerDto createdPassager = passagerService.addPassager(passagerDto);
	        return ResponseEntity.ok(createdPassager);
	    }
	 @PutMapping("/passager/{uuid}")
	    public ResponseEntity<PassagerDto> updatePassager(@RequestBody PassagerDto passagerDto, @PathVariable String uuid) {
		 PassagerDto updatedPassager = passagerService.updatePassager(passagerDto, uuid);
	        return ResponseEntity.ok(updatedPassager);
	    }
	 @GetMapping("/passager/{uuid}")
	    public ResponseEntity<PassagerDto> getPassager(@PathVariable String uuid) {
		 PassagerDto passager = passagerService.getPassager(uuid);
		 if(passager != null) {
			 return ResponseEntity.ok(passager);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
	    }
	 @GetMapping("/passager")
	    public  ResponseEntity<List<PassagerDto>> listePassager() {
		 List<PassagerDto> passagers = passagerService.listePassager();
	        return ResponseEntity.ok(passagers);
	    }
	 @DeleteMapping("/passager/{uuid}")
	    public ResponseEntity<Void> deletePassager(@PathVariable String uuid) {
		 boolean deleted = passagerService.deletePassager(uuid);
		 if(deleted) {
			 return ResponseEntity.noContent().build();
		 }else {
			 return ResponseEntity.notFound().build();
		 }       
	 }
}
