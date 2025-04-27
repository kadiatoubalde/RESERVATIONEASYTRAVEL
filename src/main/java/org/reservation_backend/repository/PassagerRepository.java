package org.reservation_backend.repository;

import java.util.List;

import org.reservation_backend.models.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagerRepository extends JpaRepository<Passager,String> {
	
	@Query("SELECT p FROM Passager p WHERE p.isDelete = false")
	List<Passager> listes();

}
