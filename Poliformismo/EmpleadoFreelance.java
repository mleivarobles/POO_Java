public class EmpleadoFreelance extends Empleado{

    double valorHora;

    public EmpleadoFreelance(String nombre, String rut, int horasContratadas, double valorHora) {
        super(nombre, rut, horasContratadas);
        this.valorHora = valorHora;
    }

    public double calcularSueldo(){
        return valorHora * horasContratadas;
    }

    @Override
    public String toString() {
        return "EmpleadoFreelance [nombre=" + nombre + ", valorHora=" + valorHora + ", rut=" + rut
                + ", horasContratadas=" + horasContratadas + "]";
    }
}
