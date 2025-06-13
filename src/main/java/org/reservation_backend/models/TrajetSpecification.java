package org.reservation_backend.models;

import jakarta.persistence.criteria.Predicate;
import org.reservation_backend.dto.SearchTrajetDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class TrajetSpecification {


    public static Specification<Trajet> withPrioritizedSearch(SearchTrajetDto dto) {
        return (root, query, cb) -> {
            // Bloc 7 : Aucun point de départ ni d'arrivée = pas de recherche
            if (dto.getDepartId() == null && dto.getArriveId() == null) {
                return cb.disjunction();
            }

            var predicates = new ArrayList<Predicate>();

            // Bloc 1 : Tous les critères
            if (dto.getDepartId() != null && dto.getArriveId() != null
                    && dto.getDateDepart() != null && dto.getTimeDepart() != null) {

                predicates.add(cb.equal(root.get("pointDepart").get("uuid"), dto.getDepartId()));
                predicates.add(cb.equal(root.get("pointArrive").get("uuid"), dto.getArriveId()));
                predicates.add(cb.equal(root.get("dateDepart"), dto.getDateDepart()));
                predicates.add(cb.greaterThanOrEqualTo(root.get("timeDepart"), dto.getTimeDepart()));

            }
            // Bloc 2 : depart + arrive + date
            else if (dto.getDepartId() != null && dto.getArriveId() != null && dto.getDateDepart() != null) {
                predicates.add(cb.equal(root.get("pointDepart").get("uuid"), dto.getDepartId()));
                predicates.add(cb.equal(root.get("pointArrive").get("uuid"), dto.getArriveId()));
                predicates.add(cb.equal(root.get("dateDepart"), dto.getDateDepart()));
            }
            // Bloc 3 : depart + arrive + heure
            else if (dto.getDepartId() != null && dto.getArriveId() != null && dto.getTimeDepart() != null) {
                predicates.add(cb.equal(root.get("pointDepart").get("uuid"), dto.getDepartId()));
                predicates.add(cb.equal(root.get("pointArrive").get("uuid"), dto.getArriveId()));
                predicates.add(cb.greaterThanOrEqualTo(root.get("timeDepart"), dto.getTimeDepart()));
            }
            // Bloc 4 : depart + arrive
            else if (dto.getDepartId() != null && dto.getArriveId() != null) {
                predicates.add(cb.equal(root.get("pointDepart").get("uuid"), dto.getDepartId()));
                predicates.add(cb.equal(root.get("pointArrive").get("uuid"), dto.getArriveId()));
            }
            // Bloc 5 : seulement départ
            else if (dto.getDepartId() != null) {
                predicates.add(cb.equal(root.get("pointDepart").get("uuid"), dto.getDepartId()));
            }
            // Bloc 6 : seulement arrivée
            else if (dto.getArriveId() != null) {
                predicates.add(cb.equal(root.get("pointArrive").get("uuid"), dto.getArriveId()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
