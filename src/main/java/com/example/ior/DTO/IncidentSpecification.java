package com.example.ior.DTO;

import com.example.ior.Entity.CauseInstances;
import com.example.ior.Entity.IncidentEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;


public class IncidentSpecification {
    public static Specification<IncidentEntity> withFilter(String author, LocalDateTime timeCreated, String causeInstancesAuthor) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicates = criteriaBuilder.conjunction();
            if (author != null && !author.isEmpty()) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("author"), author));
            }
            if (timeCreated != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("timeCreated"), timeCreated));
            }
            if (causeInstancesAuthor != null && !causeInstancesAuthor.isEmpty()) {
                Join<IncidentEntity, CauseInstances> join = root.join("causeInstancesAuthor");
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(join.get("author"), causeInstancesAuthor));
            }
            return predicates;
        };
    }
}
