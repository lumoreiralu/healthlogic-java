import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculador calc = new CalculadorSalud();
        

        Paciente p1 = new Paciente("Lucia", 29, "femenino", 39279226);
        p1.addMedida(54.0, 1.58); 
        Paciente p2 = new Paciente("Fernando", 34, "masculino", 1234);
        p2.addMedida(80.2, 1.73);

        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(p1);
        pacientes.add(p2);

        try {
            for (Paciente  p : pacientes) {
                Medida m = p.getUltimaMedida();
                System.out.println("Procesando datos de: " + p.getNombre());
                
                double imc = calc.calcularIMC(m);
                String categ = calc.obtenerCategoriaIMC(imc);
                double tmb = calc.calcularTMB(p1, m);
                double hidra = calc.calcularHidratacion(m);
    
                System.out.println("Resultados:");
                System.out.println(" - IMC: " + String.format("%.2f", imc));
                System.out.println(" - Categoria IMC: " + categ);
                System.out.println(" - TMB: " + String.format("%.2f", tmb));
                System.out.println(" - Hidratación sugerida: " + hidra + " ml"); 
            }


        } catch (DatoClinicoInvalidoException e) {

            System.out.println("Alerta de Seguridad Clínica: No se pudieron procesar los cálculos.");
            System.out.println("Motivo: " + e.getMessage());
        } catch (Exception e) {

            System.out.println("Error inesperado en el sistema.");
        }
    }
}