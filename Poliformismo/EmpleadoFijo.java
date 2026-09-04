public class EmpleadoFijo extends Empleado {
    
    double sueldoBase;

    public EmpleadoFijo(String nombre, String rut, int horasContratadas, double sueldoBase){
        super(nombre, rut, horasContratadas);
        this.sueldoBase = sueldoBase;
    }

    public double calcularSueldo(){
        return sueldoBase;
    }

    @Override
    public String toString() {
        return nombre + " | " +  rut + " | Fijo | " +  "Sueldo: $" + calcularSueldo();
    }
}
