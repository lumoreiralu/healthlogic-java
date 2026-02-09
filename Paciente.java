import java.util.ArrayList;
import java.util.List;

public class Paciente{
    private String nombre;
    private int dni;
    private int edad;
    private String sexo;
    private ArrayList<Medida> medidas;

    
    public Paciente(String nombre, int edad, String sexo, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
        this.medidas = new ArrayList<>();
    }

    public void addMedida(double peso, double altura) {
        this.medidas.add(new Medida(peso, altura));
    }

    public List<Medida> getMedidas() {
        ArrayList<Medida> copia = new ArrayList<>(medidas);
        return copia;
    }
    
    public Medida getUltimaMedida() {
        if (medidas.isEmpty()) return null;
        return medidas.get(medidas.size() - 1);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString(){
        return "El paciente con dni : " + this.getDni() + ": "; 
    }

    @Override
    public boolean equals(Object nuevo){
        try{
            Paciente otro = (Paciente) nuevo;
            return this.getDni()==otro.getDni();

        } catch (Exception e){
            return false;
        }
    }

    public int getDni() {
        return dni;
    }
    
}