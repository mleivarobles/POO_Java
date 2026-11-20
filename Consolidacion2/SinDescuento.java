/*
 * Estrategia por defecto: sin descuento.
 */
public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double precioBase) {
        return 0;
    }

    @Override
    public String getDescripcion() {
        return "Sin descuento";
    }
}
