package org.reservation_backend.repository;

import java.util.List;
import java.util.Optional;

import org.reservation_backend.models.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ModePaiementRepository  extends JpaRepository<ModePaiement,String>{

	@Query("SELECT m FROM ModePaiement m WHERE m.isDelete = false")
	List<ModePaiement> listes();
	
	Optional<ModePaiement> findByUuid(String uuid);

}
