package com.healthyapp.healthlogic.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    private Long dni; 

    private String nombre;
    private int edad;
    private String sexo;
    

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medida> medidas = new ArrayList<>();

    public Paciente() {} // Constructor vacío obligatorio para JPA

    public Paciente(Long dni, String nombre, int edad, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) { // Agregado para poder setear el DNI
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }

    public Medida getUltimaMedida() {
        if (medidas == null || medidas.isEmpty()) {
            return null;
        }
        return medidas.get(medidas.size() - 1);
    }
}