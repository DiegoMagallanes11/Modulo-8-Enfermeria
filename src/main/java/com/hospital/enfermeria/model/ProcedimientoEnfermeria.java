package com.hospital.enfermeria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "procedimientos_enfermeria")
public class ProcedimientoEnfermeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoProcedimiento;

    private String descripcion;
    private String insumosUtilizados;
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    private EstadoProcedimiento estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfermero_id", nullable = false)
    private Enfermero enfermero;

    public ProcedimientoEnfermeria() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Enfermero getEnfermero() { return enfermero; }
    public void setEnfermero(Enfermero enfermero) { this.enfermero = enfermero; }
}