package org.reservation_backend.repository;

import org.reservation_backend.Enum.EnumRoleUtilisateur;
import org.reservation_backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    @Query("SELECT u FROM Utilisateur u where u.email = :username")
    Optional<Utilisateur> findByUsername(String username);

    
    Optional<Utilisateur> findByUuid(String uuid);

    List<Utilisateur> findByRole(EnumRoleUtilisateur role);

   Optional<Utilisateur> findByUuidAndRole(String uuid, EnumRoleUtilisateur role);
    @Query("SELECT u FROM Utilisateur u LEFT JOIN FETCH u.trajets WHERE u.email = :email")
    Optional<Utilisateur> findByEmailWithTrajets(@Param("email") String email);

}
