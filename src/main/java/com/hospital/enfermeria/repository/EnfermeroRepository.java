package com.hospital.enfermeria.repository;

import com.hospital.enfermeria.model.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
}