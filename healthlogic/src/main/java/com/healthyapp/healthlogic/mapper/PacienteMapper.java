package com.healthyapp.healthlogic.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.dto.PacienteDTO;
import com.healthyapp.healthlogic.model.Paciente;

@Component
public class PacienteMapper {

    private final MedidaMapper medidaMapper;

    public PacienteMapper(MedidaMapper medidaMapper) {
        this.medidaMapper = medidaMapper;
    }

    public PacienteDTO toDTO(Paciente paciente) {
        if (paciente == null) return null;

        List<MedidaDTO> medidasDTO = null;
        if (paciente.getMedidas() != null) {
            medidasDTO = paciente.getMedidas().stream()
                .map(medidaMapper::toDTO)
                .collect(Collectors.toList());
        }

        return new PacienteDTO(
            paciente.getDni(),
            paciente.getNombre(),
            paciente.getEdad(),
            paciente.getSexo(),
            medidasDTO
        );
    }
}