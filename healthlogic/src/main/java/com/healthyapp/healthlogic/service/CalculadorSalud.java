package com.healthyapp.healthlogic.service;
import org.springframework.stereotype.Service;
import com.healthyapp.healthlogic.exception.DatoClinicoInvalidoException;
import com.healthyapp.healthlogic.model.Medida;
import com.healthyapp.healthlogic.model.Paciente;
@Service 
public class CalculadorSalud implements Calculador{

    public CalculadorSalud() {
    }
    @Override
    // metodo para calcular el IMC
    public double calcularIMC(Medida m) throws DatoClinicoInvalidoException{
        double altura = m.getAltura();
        double peso = m.getPeso();

        if (altura <= 0 || altura > 2.80) { 
            throw new DatoClinicoInvalidoException("Altura fuera de rango: " + altura);
        }
        if (peso <= 0 || peso > 600) {
            throw new DatoClinicoInvalidoException("Peso inválido para cálculo: " + peso);
        }
        return Math.round((peso / (altura * altura)) * 100.0) / 100.0;
    }
    @Override
    public String obtenerCategoriaIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        if (imc < 24.9) return "Peso normal (Eutrófico)";
        if (imc < 29.9) return "Sobrepeso";
        return "Obesidad";
    }

    @Override
    public double calcularTMB(Paciente p, Medida m) throws DatoClinicoInvalidoException {
            double tmb;
        // la altura debe estar en cm para esta fórmula
        double alturaCm = m.getAltura() * 100;
        if(alturaCm>280){
            throw new DatoClinicoInvalidoException("Altura fuera de rango: " + alturaCm);

        }
        if (p.getSexo().equalsIgnoreCase("F")) {
            tmb = 655 + (9.6 * m.getPeso()) + (1.8 * alturaCm) - (4.7 * p.getEdad());
        } else {
            tmb = 66 + (13.7 * m.getPeso()) + (5 * alturaCm) - (6.8 * p.getEdad());
        }
        return Math.round(tmb * 100.0) / 100.0; // Redondear a 2 decimales
    }

    @Override
    public double calcularHidratacion(Medida m) throws DatoClinicoInvalidoException {
        double peso = m.getPeso();
        if (peso <= 0 || peso > 600) {
            throw new DatoClinicoInvalidoException("Peso inválido para cálculo: " + peso);
        }

        if(peso <= 10)
            return Math.round(100 * peso * 100.0) / 100.0;
        else if(peso <= 20)
            return Math.round((1000 + ((peso - 10) * 50)) * 100.0) / 100.0;
        else 
            return Math.round((1500 + ((peso - 20) * 20)) * 100.0) / 100.0;
    }

}
