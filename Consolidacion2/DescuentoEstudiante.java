/*
 * MODULO 7 - OCP: nueva estrategia sin modificar codigo existente.
 * Descuento del 30% para estudiantes.
 */
public class DescuentoEstudiante implements EstrategiaDescuento {

    private static final double PORCENTAJE = 0.30;

    @Override
    public double calcularDescuento(double precioBase) {
        return precioBase * PORCENTAJE;
    }

    @Override
    public String getDescripcion() {
        return "Descuento estudiante (30%)";
    }
}
