public interface Calculador {
    double calcularIMC(double peso, double altura);
    String obtenerCategoriaIMC(double imc);
    double calcularTMB(Paciente p, Medida m);
    double calcularHidratacion(Medida m);

}
