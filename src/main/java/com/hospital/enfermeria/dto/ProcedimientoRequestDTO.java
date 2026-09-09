package com.hospital.enfermeria.dto;

import com.hospital.enfermeria.model.EstadoProcedimiento;

public class ProcedimientoRequestDTO {

    private Long pacienteId;
    private Long enfermeroId;
    private String tipoProcedimiento;
    private String descripcion;
    private String insumosUtilizados;
    private EstadoProcedimiento estado;

    public ProcedimientoRequestDTO() {}

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public Long getEnfermeroId() { return enfermeroId; }
    public void setEnfermeroId(Long enfermeroId) { this.enfermeroId = enfermeroId; }

    public String getTipoProcedimiento() { return tipoProcedimiento; }
    public void setTipoProcedimiento(String tipoProcedimiento) { this.tipoProcedimiento = tipoProcedimiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getInsumosUtilizados() { return insumosUtilizados; }
    public void setInsumosUtilizados(String insumosUtilizados) { this.insumosUtilizados = insumosUtilizados; }

    public EstadoProcedimiento getEstado() { return estado; }
    public void setEstado(EstadoProcedimiento estado) { this.estado = estado; }
}