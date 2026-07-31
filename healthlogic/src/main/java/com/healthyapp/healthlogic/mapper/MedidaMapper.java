package com.healthyapp.healthlogic.mapper;

import org.springframework.stereotype.Component;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.model.Medida;

@Component
public class MedidaMapper {

    public MedidaDTO toDTO(Medida medida) {
        if (medida == null) return null;

        Long dniPaciente = (medida.getPaciente() != null) ? medida.getPaciente().getDni() : null;

        MedidaDTO dto = new MedidaDTO(
            medida.getId(),
            medida.getFechaMedicion(),
            medida.getPeso(),
            medida.getAltura(),
            dniPaciente
        );

        dto.setTmb(medida.getTmb());
        dto.setImc(medida.getImc());
        dto.setHidratacion(medida.getHidratacion());

        return dto;
    }

    public Medida toEntity(MedidaDTO dto) {
        if (dto == null) return null;

        Medida medida = new Medida();
        medida.setId(dto.getId());
        medida.setFechaMedicion(dto.getFechaMedicion());
        medida.setPeso(dto.getPeso());
        medida.setAltura(dto.getAltura());
        medida.setTmb(dto.getTmb());
        medida.setImc(dto.getImc());
        medida.setHidratacion(dto.getHidratacion());

        return medida;
    }
}