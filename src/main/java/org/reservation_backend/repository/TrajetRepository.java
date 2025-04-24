package org.reservation_backend.repository;

import java.util.List;

import org.reservation_backend.models.Trajet;
import org.reservation_backend.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet,String> {
	List<Trajet> findByPointDepart(Ville pointDepart);

    List<Trajet> findByPointArrive(Ville pointArrive);
}
