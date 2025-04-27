package org.reservation_backend.controller;


import org.reservation_backend.dto.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private org.reservation_backend.serviceImpl.RoleService service;

    public RoleController(org.reservation_backend.serviceImpl.RoleService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleDto roleDto){

        RoleDto RoleDtoSaved = service.create(roleDto);
        return new ResponseEntity<>(RoleDtoSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> list(){

        return ResponseEntity.ok(service.all());
    }
}
