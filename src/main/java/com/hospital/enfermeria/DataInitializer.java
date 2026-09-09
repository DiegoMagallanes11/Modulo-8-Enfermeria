package com.hospital.enfermeria;

import com.hospital.enfermeria.model.Enfermero;
import com.hospital.enfermeria.model.Paciente;
import com.hospital.enfermeria.repository.EnfermeroRepository;
import com.hospital.enfermeria.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final EnfermeroRepository enfermeroRepository;

    public DataInitializer(PacienteRepository pacienteRepository, EnfermeroRepository enfermeroRepository) {
        this.pacienteRepository = pacienteRepository;
        this.enfermeroRepository = enfermeroRepository;
    }

    @Override
    public void run(String... args) {
        if (pacienteRepository.count() == 0) {
            Paciente paciente = new Paciente();
            paciente.setNombres("Juan");
            paciente.setApellidos("Pérez");
            pacienteRepository.save(paciente);
        }

        if (enfermeroRepository.count() == 0) {
            Enfermero enfermero = new Enfermero();
            enfermero.setNombres("María");
            enfermero.setApellidos("Gómez");
            enfermeroRepository.save(enfermero);
        }
    }
}