/*
 * MODULO 7 - OCP: otra estrategia agregada sin tocar las demas.
 * Descuento del 40% para tercera edad.
 */
public class DescuentoTerceraEdad implements EstrategiaDescuento {

    private static final double PORCENTAJE = 0.40;

    @Override
    public double calcularDescuento(double precioBase) {
        return precioBase * PORCENTAJE;
    }

    @Override
    public String getDescripcion() {
        return "Descuento tercera edad (40%)";
    }
}
