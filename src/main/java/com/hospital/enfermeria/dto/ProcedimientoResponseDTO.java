package com.hospital.enfermeria.dto;

import com.hospital.enfermeria.model.EstadoProcedimiento;
import java.time.LocalDateTime;

public class ProcedimientoResponseDTO {

    private Long id;
    private Long pacienteId;
    private String nombrePaciente;
    private Long enfermeroId;
    private String nombreEnfermero;
    private String tipoProcedimiento;
    private String descripcion;
    private String insumosUtilizados;
    private LocalDateTime fechaHora;
    private EstadoProcedimiento estado;

    public ProcedimientoResponseDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public String getNombrePaciente() { return nombrePaciente; }
    public void setNombrePaciente(String nombrePaciente) { this.nombrePaciente = nombrePaciente; }

    public Long getEnfermeroId() { return enfermeroId; }
    public void setEnfermeroId(Long enfermeroId) { this.enfermeroId = enfermeroId; }

    public String getNombreEnfermero() { return nombreEnfermero; }
    public void setNombreEnfermero(String nombreEnfermero) { this.nombreEnfermero = nombreEnfermero; }

    public String getTipoProcedimiento() { return tipoProcedimiento; }
    public void setTipoProcedimiento(String tipoProcedimiento) { this.tipoProcedimiento = tipoProcedimiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getInsumosUtilizados() { return insumosUtilizados; }
    public void setInsumosUtilizados(String insumosUtilizados) { this.insumosUtilizados = insumosUtilizados; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public EstadoProcedimiento getEstado() { return estado; }
    public void setEstado(EstadoProcedimiento estado) { this.estado = estado; }
}