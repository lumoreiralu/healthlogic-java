public interface Calculador {
    double calcularIMC(Medida m) throws DatoClinicoInvalidoException;
    String obtenerCategoriaIMC(double imc) throws DatoClinicoInvalidoException;
    double calcularTMB(Paciente p, Medida m) throws DatoClinicoInvalidoException;
    double calcularHidratacion(Medida m) throws DatoClinicoInvalidoException;

}
