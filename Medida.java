import java.time.LocalDate;

public class Medida {
    private LocalDate fechaMedicion;
    private double peso;
    private double altura;

    
    public Medida(double peso, double altura) {
        this.fechaMedicion = LocalDate.now();
        this.peso = peso;
        this.altura = altura;
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



    public LocalDate getFechaMedicion() {
        return fechaMedicion;
    }

    
}
