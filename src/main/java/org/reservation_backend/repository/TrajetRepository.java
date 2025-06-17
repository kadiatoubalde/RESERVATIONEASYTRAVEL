package org.reservation_backend.repository;

import java.util.List;
import java.util.Optional;

import org.reservation_backend.models.Trajet;
import org.reservation_backend.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet,String>, JpaSpecificationExecutor<Trajet> {
	List<Trajet> findByPointDepart(Ville pointDepart);

    List<Trajet> findByPointArrive(Ville pointArrive);

    Optional<Trajet> findByUuid(String uuid);
}
