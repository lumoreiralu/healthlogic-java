package com.healthyapp.healthlogic.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MedidaDTO {
    private Long id;
    private LocalDate fechaMedicion;
    private Double peso;
    private Double altura;
    private Long dniPaciente;

    // Solo lectura: el cliente recibe los valores, pero no puede enviarlos
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double tmb;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double imc;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double hidratacion;

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


    
    public Double getTmb() {
        return tmb;
    }

    public void setTmb(Double tmb) {
        this.tmb = tmb;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Double getHidratacion() {
        return hidratacion;
    }

    public void setHidratacion(Double hidratacion) {
        this.hidratacion = hidratacion;
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