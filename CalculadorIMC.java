public class CalculadorIMC implements Calculador{

    public CalculadorIMC() {
    }

    // metodo para calcular el IMC
    public double calcularIMC(double peso, double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor a cero");
        }
        return peso / (altura * altura);
    }
        
    public String obtenerCategoriaIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        if (imc < 24.9) return "Peso normal (Eutrófico)";
        if (imc < 29.9) return "Sobrepeso";
        return "Obesidad";
    }
}
