package com.healthyapp.healthlogic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthyapp.healthlogic.dto.PacienteDTO;
import com.healthyapp.healthlogic.mapper.PacienteMapper;
import com.healthyapp.healthlogic.model.Paciente;
import com.healthyapp.healthlogic.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;


    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
        Paciente pacienteGuardado = pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(pacienteGuardado);
    }

    public List<PacienteDTO> obtenerPacientes() {
        return pacienteRepository.findAll().stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarPaciente(Long dni) {
        pacienteRepository.deleteById(dni);
    }

    public PacienteDTO actualizarPaciente(Long dni, PacienteDTO pacienteDTO) {
        Paciente pacienteExistente = pacienteRepository.findById(dni)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con DNI: " + dni));

        // Actualizar los campos del paciente existente
        pacienteExistente.setNombre(pacienteDTO.getNombre());
        pacienteExistente.setEdad(pacienteDTO.getEdad());
        pacienteExistente.setSexo(pacienteDTO.getSexo());

        // Guardar cambios y devolver el DTO actualizado
        Paciente pacienteGuardado = pacienteRepository.save(pacienteExistente);
        return pacienteMapper.toDTO(pacienteGuardado);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }
}