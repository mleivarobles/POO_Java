/*
 * MODULO 7 - Principio Abierto/Cerrado (OCP) via Strategy Pattern
 *
 * Interfaz para estrategias de descuento. Para agregar un nuevo tipo de
 * descuento (ej: descuento por grupo), solo se crea una nueva clase que
 * implemente esta interfaz — sin modificar las clases existentes.
 *
 * Tambien demuestra DIP: Cine depende de esta abstraccion,
 * no de una implementacion concreta de descuento.
 */
public interface EstrategiaDescuento {

    double calcularDescuento(double precioBase);

    String getDescripcion();
}
