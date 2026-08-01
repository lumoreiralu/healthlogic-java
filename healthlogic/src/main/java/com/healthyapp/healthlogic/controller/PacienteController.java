package com.healthyapp.healthlogic.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.healthyapp.healthlogic.dto.PacienteDTO;
import com.healthyapp.healthlogic.dto.PacienteSelectDTO;
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

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long dni) {
        pacienteService.eliminarPaciente(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{dni}")
    public ResponseEntity<PacienteDTO> actualizarPaciente(@PathVariable Long dni, @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO pacienteActualizado = pacienteService.actualizarPaciente(dni, pacienteDTO);
        return ResponseEntity.ok(pacienteActualizado);
    }

    @GetMapping("/select")
    public ResponseEntity<List<PacienteSelectDTO>> obtenerPacientesParaSelect() {
        List<PacienteSelectDTO> pacientes = pacienteService.obtenerTodosLosPacientes()
            .stream()
            .map(p -> new PacienteSelectDTO(p.getDni(), p.getNombre(), p.getApellido()))
            .collect(Collectors.toList());
            
        return ResponseEntity.ok(pacientes);
    }

    
   
}
