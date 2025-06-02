package org.reservation_backend.serviceImpl;

import org.reservation_backend.Enum.EnumRoleUtilisateur;
import org.reservation_backend.dto.UtilisateurDto;
import org.reservation_backend.exception.ResourceAlreadyExistException;
import org.reservation_backend.fonction.Fonction;
import org.reservation_backend.mapper.Mapper;
import org.reservation_backend.models.Utilisateur;
import org.reservation_backend.repository.RoleRepository;
import org.reservation_backend.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UtilisateurService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(UtilisateurService.class);
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UtilisateurService( @Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UtilisateurDto register(UtilisateurDto userDto){
        logger.info("=========> registering user");
        // Check if email already exists
        if(userRepository.findByUsername(userDto.getEmail()).isPresent()){
            throw new ResourceAlreadyExistException(String.format("L'adresse email %s existe déjà", userDto.getEmail()));
        }
        userDto.setRole(userDto.getRole().toUpperCase());
        Utilisateur user = Mapper.toUtilisateur(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
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


    public List<UtilisateurDto> getAll() {
        return Mapper.toUtilisateurDtoList(userRepository.findAll());
    }

    public String deleteByuuid(String uuid) {
        userRepository.deleteById(uuid);
        return  "id : "+ uuid + "supprim<UNK>";
    }

    public ResponseEntity<UtilisateurDto> update(String uuid,UtilisateurDto utilisateurDto) {
        Utilisateur user = userRepository.findByUuid(uuid).orElseThrow(
                ()->new RuntimeException(String.format("User: %s, not found", uuid))
        );
        user = Fonction.updateEntityWithNonNullFields(user,utilisateurDto,"uuid");
        userRepository.save(user);
        return ResponseEntity.ok(Mapper.toUtilisateurDto(user));
    }

    public List<UtilisateurDto> getByRole(String role) {
        List<Utilisateur> utilisateurs = userRepository.findByRole(EnumRoleUtilisateur.valueOf(role));
        return Mapper.toUtilisateurDtoList(utilisateurs);
    }
}
