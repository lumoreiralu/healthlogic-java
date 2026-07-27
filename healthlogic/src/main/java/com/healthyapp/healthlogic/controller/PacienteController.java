package com.healthyapp.healthlogic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.healthyapp.healthlogic.dto.PacienteDTO;

import com.healthyapp.healthlogic.service.PacienteService;
@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*") // Permite la conexión desde React
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<PacienteDTO> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }
}
