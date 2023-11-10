package com.example.ior.repository;

import com.example.ior.Entity.IncidentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IorRepository extends JpaRepository<IncidentEntity, String>{
  List<IncidentEntity> findAll(Specification<IncidentEntity> specification, Pageable pageable);
}
