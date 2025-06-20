package org.reservation_backend.repository;

import java.util.List;
import java.util.Optional;

import org.reservation_backend.dto.PassagerDto;
import org.reservation_backend.models.Reservation;
import org.reservation_backend.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
	@Query("SELECT r FROM Reservation r WHERE r.isDelete = false")
    List<Reservation> listes();
	
	Optional<Reservation> findByUuid(String uuid);

	@Query("SELECT SUM(r.nombreBillets) FROM Reservation r WHERE r.trajet.id = :trajetId")
	Optional<Integer> sumNombreBilletsByTrajetId(@Param("trajetId") String trajetId);

	@Query("""
		SELECT new org.reservation_backend.dto.PassagerDto(
			r.passager.uuid,
			r.passager.firstname,
			r.passager.lastname,
			r.passager.telephone,
			SUM(r.nombreBillets)
		)
		FROM Reservation r
		WHERE r.trajet.chauffeur.id = :chauffeurId
		GROUP BY r.passager.uuid, r.passager.firstname, r.passager.lastname, r.passager.telephone
	""")
	List<PassagerDto> findPassagerDtosByChauffeurId(@Param("chauffeurId") String chauffeurId);


}
