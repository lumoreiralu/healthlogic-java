import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paciente  Lucia = new Paciente("Lucia Moreira", 1.53, 1.58, 29, "femenino", 39279226);
        Paciente Fernando = new Paciente("Fernando", 82, 1.70, 34, "masculino", 123456);

        CalculadorSalud calc = new CalculadorSalud();


        List<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes.add(Fernando);
        listaPacientes.add(Lucia);

        System.out.println("--- Reporte de Salud de Pacientes ---");
        
        for (Paciente p : listaPacientes) {
            
            double imcResultado = calc.calcularIMC(p.getPeso(), p.getAltura());
            String categoria = calc.obtenerCategoriaIMC(imcResultado);

            
            System.out.println(p.getNombre() + ":");
            System.out.println(" > IMC: " + String.format("%.2f", imcResultado));
            System.out.println(" > Categoría: " + categoria);
            System.out.println("-----------------------------------");
        }
    }
    
}
