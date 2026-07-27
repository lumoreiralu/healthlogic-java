package com.healthyapp.healthlogic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.mapper.MedidaMapper;
import com.healthyapp.healthlogic.model.Medida;
import com.healthyapp.healthlogic.model.Paciente;
import com.healthyapp.healthlogic.repository.MedidaRepository;
import com.healthyapp.healthlogic.repository.PacienteRepository;

@Service
public class MedidaService {

    private final MedidaRepository medidaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedidaMapper medidaMapper;

    public MedidaService(MedidaRepository medidaRepository, 
                         PacienteRepository pacienteRepository, 
                         MedidaMapper medidaMapper) {
        this.medidaRepository = medidaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medidaMapper = medidaMapper;
    }

    // Obtener todas las medidas de un paciente por su DNI
    public List<MedidaDTO> obtenerMedidasPorPaciente(Long dni) {
        return medidaRepository.findByPacienteDni(dni).stream()
                .map(medidaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Guardar una nueva medida asociada a un paciente
    public MedidaDTO agregarMedida(Long dni, MedidaDTO medidaDTO) {
        Paciente paciente = pacienteRepository.findById(dni)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con DNI: " + dni));

        Medida medida = medidaMapper.toEntity(medidaDTO);
        medida.setPaciente(paciente);

        // Si no viene fecha en el DTO, asignamos la fecha actual
        if (medida.getFechaMedicion() == null) {
            medida.setFechaMedicion(LocalDate.now());
        }

        Medida medidaGuardada = medidaRepository.save(medida);
        return medidaMapper.toDTO(medidaGuardada);
    }
}