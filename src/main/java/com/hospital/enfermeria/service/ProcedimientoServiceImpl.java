package com.hospital.enfermeria.service;

import com.hospital.enfermeria.dto.ProcedimientoRequestDTO;
import com.hospital.enfermeria.dto.ProcedimientoResponseDTO;
import com.hospital.enfermeria.model.Enfermero;
import com.hospital.enfermeria.model.Paciente;
import com.hospital.enfermeria.model.ProcedimientoEnfermeria;
import com.hospital.enfermeria.repository.EnfermeroRepository;
import com.hospital.enfermeria.repository.PacienteRepository;
import com.hospital.enfermeria.repository.ProcedimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService {

    private final ProcedimientoRepository procedimientoRepository;
    private final PacienteRepository pacienteRepository;
    private final EnfermeroRepository enfermeroRepository;

    public ProcedimientoServiceImpl(ProcedimientoRepository procedimientoRepository,
                                    PacienteRepository pacienteRepository,
                                    EnfermeroRepository enfermeroRepository) {
        this.procedimientoRepository = procedimientoRepository;
        this.pacienteRepository = pacienteRepository;
        this.enfermeroRepository = enfermeroRepository;
    }

    @Override
    public ProcedimientoResponseDTO registrarProcedimiento(ProcedimientoRequestDTO request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Enfermero enfermero = enfermeroRepository.findById(request.getEnfermeroId())
                .orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));

        ProcedimientoEnfermeria procedimiento = new ProcedimientoEnfermeria();
        procedimiento.setTipoProcedimiento(request.getTipoProcedimiento());
        procedimiento.setDescripcion(request.getDescripcion());
        procedimiento.setInsumosUtilizados(request.getInsumosUtilizados());
        procedimiento.setEstado(request.getEstado());
        procedimiento.setFechaHora(LocalDateTime.now());
        procedimiento.setPaciente(paciente);
        procedimiento.setEnfermero(enfermero);

        ProcedimientoEnfermeria guardado = procedimientoRepository.save(procedimiento);
        return mapToDTO(guardado);
    }

    @Override
    public List<ProcedimientoResponseDTO> obtenerHistorialPorPaciente(Long pacienteId) {
        return procedimientoRepository.findByPacienteIdOrderByFechaHoraDesc(pacienteId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProcedimientoResponseDTO mapToDTO(ProcedimientoEnfermeria entity) {
        ProcedimientoResponseDTO dto = new ProcedimientoResponseDTO();
        dto.setId(entity.getId());
        dto.setPacienteId(entity.getPaciente().getId());
        dto.setNombrePaciente(entity.getPaciente().getNombres() + " " + entity.getPaciente().getApellidos());
        dto.setEnfermeroId(entity.getEnfermero().getId());
        dto.setNombreEnfermero(entity.getEnfermero().getNombres() + " " + entity.getEnfermero().getApellidos());
        dto.setTipoProcedimiento(entity.getTipoProcedimiento());
        dto.setDescripcion(entity.getDescripcion());
        dto.setInsumosUtilizados(entity.getInsumosUtilizados());
        dto.setFechaHora(entity.getFechaHora());
        dto.setEstado(entity.getEstado());
        return dto;
    }
}