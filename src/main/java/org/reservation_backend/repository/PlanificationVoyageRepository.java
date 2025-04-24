package org.reservation_backend.repository;

import org.reservation_backend.models.PlanificationVoyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanificationVoyageRepository  extends JpaRepository<PlanificationVoyage,String>{

   @Query("select p from PlanificationVoyage p where p.isDelete = false")
   public List<PlanificationVoyage> listes();

}
