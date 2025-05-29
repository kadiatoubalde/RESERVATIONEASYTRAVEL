package org.reservation_backend.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.reservation_backend.config.security.JwtUtil;
import org.reservation_backend.dto.AuthDto;
import org.reservation_backend.dto.UtilisateurDto;
import org.reservation_backend.exception.AccountException;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtilisateurService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;


    @PostMapping("/login")
    public ResponseEntity<UtilisateurDto> login(@RequestBody @Valid AuthDto authDto){
        try {
            UsernamePasswordAuthenticationToken ua = new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword());
            Authentication authentication = authenticationManager.authenticate( ua );
            Utilisateur user = (Utilisateur) authentication.getPrincipal();
            UtilisateurDto userDto = Mapper.toUtilisateurDto(user);
            String token = jwtTokenUtil.generateToken(user.getUsername(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
            userDto.setToken(token);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token )
                    .body(userDto);
        }catch (BadCredentialsException | ClassCastException e){
            SecurityContextHolder.getContext().setAuthentication(null);
            System.out.println("============: ");
            System.out.println(e);
            System.out.println("============: ");
            e.printStackTrace();
            throw new AccountException("Identifiant ou mot de passe incorrect");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UtilisateurDto> register(@RequestBody @Valid UtilisateurDto userDto){
        return new ResponseEntity<UtilisateurDto>(userService.register(userDto), HttpStatus.CREATED);
    }


    @GetMapping("/validateToken")
    public boolean validateToken(@RequestParam(required = true) String token){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("-------------------------------"+auth.getName()+"----------------------------");
        return  jwtTokenUtil.validateToken(token,auth.getName());
    }
}


