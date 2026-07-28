package com.healthyapp.healthlogic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO nuevoPaciente = pacienteService.agregarPaciente(pacienteDTO);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PacienteDTO> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }
}
