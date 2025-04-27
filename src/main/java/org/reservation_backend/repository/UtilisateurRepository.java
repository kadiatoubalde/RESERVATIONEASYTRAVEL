package org.reservation_backend.repository;

import org.reservation_backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    @Query("SELECT u FROM Utilisateur u where u.email = :username")
    Optional<Utilisateur> findByUsername(String username);

}
