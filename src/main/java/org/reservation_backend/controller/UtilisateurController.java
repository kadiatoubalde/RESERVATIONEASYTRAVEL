package org.reservation_backend.controller;

import lombok.Getter;
import org.reservation_backend.dto.UtilisateurDto;
import org.reservation_backend.serviceImpl.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/list")
    private List<UtilisateurDto> list(){
        return utilisateurService.getAll();
    }
    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable String uuid){
       return utilisateurService.deleteByuuid(uuid);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<UtilisateurDto> update(@PathVariable String uuid,@RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.update(uuid,utilisateurDto);
    }

    @PostMapping()
    public  ResponseEntity<UtilisateurDto> create(@RequestBody UtilisateurDto utilisateurDto){
        return new ResponseEntity<UtilisateurDto>(utilisateurService.register(utilisateurDto), HttpStatus.CREATED);
    }

}
