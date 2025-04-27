package org.reservation_backend.repository;

import java.util.List;

import org.reservation_backend.models.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,String> {
	
	@Query("SELECT p FROM Paiement p WHERE p.isDelete = false")
	List<Paiement> listes();
}
