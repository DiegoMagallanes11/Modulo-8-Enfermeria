package com.hospital.enfermeria.controller;

import com.hospital.enfermeria.dto.ProcedimientoRequestDTO;
import com.hospital.enfermeria.dto.ProcedimientoResponseDTO;
import com.hospital.enfermeria.service.ProcedimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enfermeria/procedimientos")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    // RF-ENF-25: Registrar procedimiento
    @PostMapping
    public ResponseEntity<ProcedimientoResponseDTO> registrar(@RequestBody ProcedimientoRequestDTO dto) {
        ProcedimientoResponseDTO response = procedimientoService.registrarProcedimiento(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // RF-ENF-27: Consultar historial de procedimientos por paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<ProcedimientoResponseDTO>> obtenerHistorial(@PathVariable Long pacienteId) {
        List<ProcedimientoResponseDTO> historial = procedimientoService.obtenerHistorialPorPaciente(pacienteId);
        return ResponseEntity.ok(historial);
    }
}