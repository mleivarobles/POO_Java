/*
 * MODULO 6 - DEPENDENCIA
 * MODULO 7 - SRP (solo calcula precios) y DIP (recibe EstrategiaDescuento)
 *
 * Se usa como variable local dentro de Sala.venderBoleto():
 * se crea, se invoca calcular(), y se descarta.
 * No es atributo de nadie — eso es lo que define la dependencia.
 *
 * Recibe la estrategia de descuento como parametro (DIP):
 * no sabe ni le importa que tipo concreto de descuento se aplica.
 */
public class CalculadoraPrecio {

    public double calcular(double precioBase, EstrategiaDescuento estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("La estrategia de descuento no puede ser nula");
        }
        double descuento = estrategia.calcularDescuento(precioBase);
        double precioFinal = precioBase - descuento;
        return Math.max(precioFinal, 0); // nunca negativo
    }
}
