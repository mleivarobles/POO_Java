public class EmpleadoComision extends Empleado{

    double sueldoBase;
    double ventasMes;
    double comision;
    public EmpleadoComision(String nombre, String rut, int horasContratadas, double sueldoBase, double ventasMes,
            double comision) {
        super(nombre, rut, horasContratadas);
        this.sueldoBase = sueldoBase;
        this.ventasMes = ventasMes;
        this.comision = comision;
    }

    public double calcularSueldo(){
        return sueldoBase + (ventasMes * comision);
    }

    @Override
    public String toString() {
        return "EmpleadoComision [nombre=" + nombre + ", sueldoBase=" + sueldoBase + ", rut=" + rut + ", ventasMes="
                + ventasMes + ", comision=" + comision + "]";
    }
}
