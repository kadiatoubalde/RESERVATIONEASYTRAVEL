package org.reservation_backend.repository;

import org.reservation_backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query("""
            select r from Role r where r.code IN :codes
            """)
    Set<Role> findAllByCodes(List<String> codes);
}
