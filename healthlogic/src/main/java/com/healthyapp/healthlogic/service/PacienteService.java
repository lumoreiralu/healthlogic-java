package com.healthyapp.healthlogic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthyapp.healthlogic.dto.PacienteDTO;
import com.healthyapp.healthlogic.mapper.PacienteMapper;
import com.healthyapp.healthlogic.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;
    private final Calculador calculador;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper, Calculador calculador) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
        this.calculador = calculador;
    }

    public List<PacienteDTO> obtenerPacientes() {
        return pacienteRepository.findAll().stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}