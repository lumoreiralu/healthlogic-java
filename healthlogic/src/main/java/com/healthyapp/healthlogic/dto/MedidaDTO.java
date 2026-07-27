package com.healthyapp.healthlogic.dto;

import java.time.LocalDate;

public class MedidaDTO {
    private Long id;
    private LocalDate fechaMedicion;
    private Double peso;
    private Double altura;
    private Long dniPaciente;

    // Constructor vacío
    public MedidaDTO() {}

    // Constructor sin DNI
    public MedidaDTO(Long id, LocalDate fechaMedicion, Double peso, Double altura) {
        this.id = id;
        this.fechaMedicion = fechaMedicion;
        this.peso = peso;
        this.altura = altura;
    }

    // Constructor completo (con DNI del paciente)
    public MedidaDTO(Long id, LocalDate fechaMedicion, Double peso, Double altura, Long dniPaciente) {
        this.id = id;
        this.fechaMedicion = fechaMedicion;
        this.peso = peso;
        this.altura = altura;
        this.dniPaciente = dniPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Agregado para que compile toMedidaEntity
        this.id = id;
    }

    public LocalDate getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(LocalDate fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Long getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(Long dniPaciente) {
        this.dniPaciente = dniPaciente;
    }
}