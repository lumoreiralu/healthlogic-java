package com.healthyapp.healthlogic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.healthyapp.healthlogic.dto.MedidaDTO;
import com.healthyapp.healthlogic.exception.DatoClinicoInvalidoException;
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
    private final CalculadorSalud calculador;

    public MedidaService(MedidaRepository medidaRepository, 
                         PacienteRepository pacienteRepository, 
                         MedidaMapper medidaMapper,
                         CalculadorSalud calculador) {
        this.medidaRepository = medidaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medidaMapper = medidaMapper;
        this.calculador = calculador;
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

        if (medida.getFechaMedicion() == null) {
            medida.setFechaMedicion(LocalDate.now());
        }

      
        try {
            medida.setTmb(calculador.calcularTMB(paciente, medida));
            medida.setImc(calculador.calcularIMC(medida));
            medida.setHidratacion(calculador.calcularHidratacion(medida));
        } catch (DatoClinicoInvalidoException e) {
            throw new RuntimeException("Error en los datos ingresados: " + e.getMessage());
        }

        // la base de datos guarda automáticamente las columnas imc, tmb e hidratacion
        Medida medidaGuardada = medidaRepository.save(medida);

        return medidaMapper.toDTO(medidaGuardada);
    }

    public void eliminarMedida(Long dni, Long id) {
        Medida medida = medidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medida no encontrada con ID: " + id));

        if (!medida.getPaciente().getDni().equals(dni)) {
            throw new RuntimeException("La medida no pertenece al paciente con DNI: " + dni);
        }

        medidaRepository.delete(medida);
    }

    public MedidaDTO obtenerTMB(Long dni, Long id) {
        Paciente paciente = pacienteRepository.findById(dni)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con DNI: " + dni));
        Medida medida = medidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medida no encontrada con ID: " + id));

        if (!medida.getPaciente().getDni().equals(dni)) {
            throw new RuntimeException("La medida no pertenece al paciente con DNI: " + dni);
        }

        MedidaDTO medidaDTO = medidaMapper.toDTO(medida);
        
        try {
            double tmb = calculador.calcularTMB(paciente, medida);
            medidaDTO.setTmb(tmb);
        } catch (DatoClinicoInvalidoException e) {
            throw new RuntimeException("Error en el cálculo de TMB: " + e.getMessage());
        }

        return medidaDTO;
    }

    public MedidaDTO obtenerIMC(Long dni, Long id) {
        Medida medida = medidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medida no encontrada con ID: " + id));

        if (!medida.getPaciente().getDni().equals(dni)) {
            throw new RuntimeException("La medida no pertenece al paciente con DNI: " + dni);
        }

        MedidaDTO medidaDTO = medidaMapper.toDTO(medida);

        try {
            double imc = calculador.calcularIMC(medida);
            medidaDTO.setImc(imc);
        } catch (DatoClinicoInvalidoException e) {
            throw new RuntimeException("Error en el cálculo de IMC: " + e.getMessage());
        }

        return medidaDTO;
    }

    public MedidaDTO obtenerHidratacion(Long dni, Long id) {
        Medida medida = medidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medida no encontrada con ID: " + id));

        if (!medida.getPaciente().getDni().equals(dni)) {
            throw new RuntimeException("La medida no pertenece al paciente con DNI: " + dni);
        }

        MedidaDTO medidaDTO = medidaMapper.toDTO(medida);

        try {
            double hidratacion = calculador.calcularHidratacion(medida);
            medidaDTO.setHidratacion(hidratacion);
        } catch (DatoClinicoInvalidoException e) {
            throw new RuntimeException("Error en el cálculo de Hidratación: " + e.getMessage());
        }

        return medidaDTO;
    }
}