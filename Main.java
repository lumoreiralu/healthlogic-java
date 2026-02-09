import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paciente  lucia = new Paciente("Lucia Moreira", 29, "femenino", 39279226);
        Paciente fernando = new Paciente("Fernando", 34, "masculino", 123456);

        CalculadorSalud calc = new CalculadorSalud();

        lucia.addMedida(58.5, 1.58); // Primera vez
        lucia.addMedida(63.4, 1.58);

        fernando.addMedida(85.3, 1.70); //Primera vez
        fernando.addMedida(80.2, 1.70);

        System.out.println("--- Reporte de Salud de Pacientes ---");
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(fernando);
        pacientes.add(lucia);

        for (Paciente p : pacientes) {
            System.out.println(p.getNombre());
            for (Medida m : p.getMedidas()) {
                double imc = calc.calcularIMC(m.getPeso(), m.getAltura());
                double tmb = calc.calcularTMB(p, m);
                double hid = calc.calcularHidratacion(m);
                System.out.println("Fecha: " + m.getFechaMedicion() + 
                                   " | Peso: " + m.getPeso() + 
                                   " | IMC: " + String.format("%.2f", imc) +
                                   " | TMB: " + String.format("%.2f",tmb) +
                                    "| HIDRAT: " + hid + " lts.");

            }
        }
    }
    
}
