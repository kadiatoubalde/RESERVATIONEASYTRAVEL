package org.reservation_backend.repository;

import java.util.List;

import org.reservation_backend.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
	@Query("SELECT r FROM Reservation r WHERE r.isDelete = false")
    List<Reservation> listes();
}
