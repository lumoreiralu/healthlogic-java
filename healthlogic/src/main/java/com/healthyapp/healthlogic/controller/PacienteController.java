package com.healthyapp.healthlogic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.healthyapp.healthlogic.model.Paciente;
import com.healthyapp.healthlogic.repository.PacienteRepository;
@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*") // Permite la conexión desde React
public class PacienteController {
    private final PacienteRepository pacienteRepo;

    public PacienteController(PacienteRepository pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    @GetMapping
    public List<Paciente> obtenerPacientes() {
        return pacienteRepo.findAll();
    }
}
