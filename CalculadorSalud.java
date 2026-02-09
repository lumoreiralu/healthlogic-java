public class CalculadorSalud implements Calculador{

    public CalculadorSalud() {
    }

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
        return peso / (altura * altura);
    }
        
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
        if(alturaCm>2800){
            throw new DatoClinicoInvalidoException("Altura fuera de rango: " + alturaCm);

        }
        if (p.getSexo().equalsIgnoreCase("Femenino")) {
            tmb = 655 + (9.6 * m.getPeso()) + (1.8 * alturaCm) - (4.7 * p.getEdad());
        } else {
            tmb = 66 + (13.7 * m.getPeso()) + (5 * alturaCm) - (6.8 * p.getEdad());
        }
        return tmb;
    }

    @Override
    public double calcularHidratacion(Medida m) throws DatoClinicoInvalidoException {
        double peso = m.getPeso();
        if (peso <= 0 || peso > 600) {
            throw new DatoClinicoInvalidoException("Peso inválido para cálculo: " + peso);
        }
        double liquidoTotal = 0;

        if(peso <= 10)
            liquidoTotal = 100 * peso;
        else if(peso <= 20)
            liquidoTotal = 1000 + ((peso - 10) * 50);
        else 
            liquidoTotal = 1500 + ((peso - 20) * 20);

        return liquidoTotal;
    }

}
