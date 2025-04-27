package org.reservation_backend.repository;

import java.util.List;

import org.reservation_backend.models.PlanificationVoyage;
import org.reservation_backend.models.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,String> {
	@Query("select v from Vehicule v where v.isDelete = false")
	   public List<Vehicule> listes();
}
