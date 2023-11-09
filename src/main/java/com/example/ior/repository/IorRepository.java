package com.example.ior.repository;

import com.example.ior.Entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IorRepository extends JpaRepository<IncidentEntity, String> {
}
