package org.reservation_backend.repository;

import org.reservation_backend.models.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagerRepository extends JpaRepository<Passager,String> {
}
