package com.hospital.enfermeria.service;

import com.hospital.enfermeria.dto.ProcedimientoRequestDTO;
import com.hospital.enfermeria.dto.ProcedimientoResponseDTO;

import java.util.List;

public interface ProcedimientoService {
    ProcedimientoResponseDTO registrarProcedimiento(ProcedimientoRequestDTO request);
    List<ProcedimientoResponseDTO> obtenerHistorialPorPaciente(Long pacienteId);
}