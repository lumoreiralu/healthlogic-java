package com.healthyapp.healthlogic.mapper;

import org.springframework.stereotype.Component;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.model.Medida;

@Component
public class MedidaMapper {

    public MedidaDTO toDTO(Medida medida) {
        if (medida == null) return null;

        Long dniPaciente = (medida.getPaciente() != null) ? medida.getPaciente().getDni() : null;

        return new MedidaDTO(
            medida.getId(),
            medida.getFechaMedicion(),
            medida.getPeso(),
            medida.getAltura(),
            dniPaciente
        );
    }

    public Medida toEntity(MedidaDTO dto) {
        if (dto == null) return null;

        Medida medida = new Medida();
        medida.setId(dto.getId());
        medida.setFechaMedicion(dto.getFechaMedicion());
        medida.setPeso(dto.getPeso());
        medida.setAltura(dto.getAltura());

        return medida;
    }
}