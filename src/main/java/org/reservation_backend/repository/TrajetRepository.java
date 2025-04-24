package org.reservation_backend.repository;

import org.reservation_backend.models.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet,String> {
}
