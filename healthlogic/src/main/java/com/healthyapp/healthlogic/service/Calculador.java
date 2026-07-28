package com.healthyapp.healthlogic.service;

import com.healthyapp.healthlogic.exception.DatoClinicoInvalidoException;
import com.healthyapp.healthlogic.model.Medida;
import com.healthyapp.healthlogic.model.Paciente;

public interface Calculador {
    double calcularIMC(Medida m) throws DatoClinicoInvalidoException;
    String obtenerCategoriaIMC(double imc) throws DatoClinicoInvalidoException;
    double calcularTMB(Paciente p, Medida m) throws DatoClinicoInvalidoException;
    double calcularHidratacion(Medida m) throws DatoClinicoInvalidoException;

}
