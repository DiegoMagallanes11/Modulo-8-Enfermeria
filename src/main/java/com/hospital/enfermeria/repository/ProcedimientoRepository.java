package com.hospital.enfermeria.repository;

import com.hospital.enfermeria.model.ProcedimientoEnfermeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimientoRepository extends JpaRepository<ProcedimientoEnfermeria, Long> {

    // RF-ENF-27: Consultar historial de procedimientos por paciente (del más reciente al más antiguo)
    List<ProcedimientoEnfermeria> findByPacienteIdOrderByFechaHoraDesc(Long pacienteId);
}