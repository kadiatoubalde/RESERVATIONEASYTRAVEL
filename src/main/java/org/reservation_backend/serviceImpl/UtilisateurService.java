package org.reservation_backend.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.reservation_backend.dto.UtilisateurDto;
import org.reservation_backend.exception.ResourceAlreadyExistException;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.repository.RoleRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class UtilisateurService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(UtilisateurService.class);

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UtilisateurService(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UtilisateurDto register(UtilisateurDto userDto){
        logger.info("=========> registering user");
        // Check if email already exists
        if(userRepository.findByUsername(userDto.getEmail()).isPresent()){
            throw new ResourceAlreadyExistException(String.format("L'adresse email %s existe déjà", userDto.getEmail()));
        }

        Utilisateur user = Mapper.toUtilisateur(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.findAllByCodes(userDto.getRoles()).stream().collect(Collectors.toSet()));

        Utilisateur savedUser = userRepository.save(user);

        return Mapper.toUtilisateurDto(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User: %s, not found", username)));
    }
    
    public Utilisateur getCurrentUser() {
    	Utilisateur user =  (Utilisateur) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
    	return user;
    }
    
    
    

}
