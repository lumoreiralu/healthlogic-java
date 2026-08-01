package com.healthyapp.healthlogic.dto;

import java.util.List;

public class PacienteDTO {
    private Long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private List<MedidaDTO> medidas;

    // Constructores, Getters y Setters
    public PacienteDTO() {}

    public PacienteDTO(Long dni, String nombre, String apellido, int edad, String sexo, List<MedidaDTO> medidas) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.medidas = medidas;
    }

    
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
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

    public List<MedidaDTO> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<MedidaDTO> medidas) {
        this.medidas = medidas;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}
