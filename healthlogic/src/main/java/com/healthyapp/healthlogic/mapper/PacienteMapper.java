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

    public Paciente toEntity(PacienteDTO dto) {
        if (dto == null) return null;

        Paciente paciente = new Paciente();
        paciente.setDni(dto.getDni());
        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setEdad(dto.getEdad());
        paciente.setSexo(dto.getSexo());

        // Convertir la lista de MedidaDTO a Medida
        if (dto.getMedidas() != null) {
            List<MedidaDTO> medidasDTO = dto.getMedidas();
            List<com.healthyapp.healthlogic.model.Medida> medidas = medidasDTO.stream()
                    .map(medidaMapper::toEntity)
                    .collect(Collectors.toList());
            paciente.setMedidas(medidas);
        }

        return paciente;
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
            paciente.getApellido(),
            paciente.getEdad(),
            paciente.getSexo(),
            medidasDTO
        );
    }
}