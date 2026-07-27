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