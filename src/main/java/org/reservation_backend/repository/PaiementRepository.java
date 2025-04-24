package org.reservation_backend.repository;

import org.reservation_backend.models.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,String> {
}
