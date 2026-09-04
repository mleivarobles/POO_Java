public abstract class Empleado {

    String nombre;
    String rut;
    int horasContratadas;

    public Empleado(String nombre, String rut, int horasContratadas) {
        this.nombre = nombre;
        this.rut = rut;
        this.horasContratadas = horasContratadas;
    }
    
    // metodo concreto
    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", rut=" + rut + ", horasContratadas=" + horasContratadas + "]";
    }

    // metodo abstracto
    abstract double calcularSueldo();
}