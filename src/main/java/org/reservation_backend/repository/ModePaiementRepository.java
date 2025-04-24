package org.reservation_backend.repository;

import org.reservation_backend.models.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModePaiementRepository  extends JpaRepository<ModePaiement,String>{

}
