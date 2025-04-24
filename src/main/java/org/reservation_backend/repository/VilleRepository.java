package org.reservation_backend.repository;

import org.reservation_backend.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,String> {
}
