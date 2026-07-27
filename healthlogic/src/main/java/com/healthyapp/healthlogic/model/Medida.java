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
    private double peso;
    private double altura;

    @ManyToOne
    @JoinColumn(name = "dni_paciente")
    private Paciente paciente;

    public Medida() {}


    
    public Long getId() {
        return id;
    }



    public Paciente getPaciente() {
        return paciente;
    }



    public Medida(double peso, double altura, Paciente paciente) {
        this.fechaMedicion = LocalDate.now();
        this.peso = peso;
        this.altura = altura;
        this.paciente = paciente;
    }

    public LocalDate getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(LocalDate fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

   
    
}
