public class Paciente{
    private String nombre;
    private int dni;
    private double peso;
    private double altura;
    private int edad;
    private String sexo;

    
    public Paciente(String nombre, double peso, double altura, int edad, String sexo, int dni) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "El paciente con dni : " + this.getDni() + ", tiene un peso de: " + 
               this.getPeso() + " Kg, y una altura de: " + this.getAltura() + " Mts" ;
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