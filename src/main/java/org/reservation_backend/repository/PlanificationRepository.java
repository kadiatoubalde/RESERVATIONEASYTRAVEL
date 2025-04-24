package org.reservation_backend.repository;

import org.reservation_backend.models.PlanificationVoyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationRepository extends JpaRepository<PlanificationVoyage,String> {

}
