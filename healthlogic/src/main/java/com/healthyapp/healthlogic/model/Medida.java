package com.healthyapp.healthlogic.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medida")
public class Medida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaMedicion;
    private Double peso;
    private Double altura;
    @Transient private Double tmb; // Agregado para almacenar el TMB calculado
    @Transient private Double imc; // Agregado para almacenar el IMC calculado
    @Transient private Double hidratacion; // Agregado para almacenar la hidratación calculada

    
    @ManyToOne
    @JoinColumn(name = "dni_paciente")
    private Paciente paciente;

    public Medida() {}

    public Medida(Double peso, Double altura, Paciente paciente) {
        this.fechaMedicion = LocalDate.now();
        this.peso = peso;
        this.altura = altura;
        this.paciente = paciente;
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

    public void setTmb(Double tmb) {
        this.tmb = tmb;
    }

    public Double getTmb() {
        return tmb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Agregado para el mapper
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) { // Agregado para el mapper y service
        this.paciente = paciente;
    }
}