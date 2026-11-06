package Paso2_OCP;

// OCP: agregar Chocolate mañana = clase nueva, cero modificaciones
public class Chocolate extends Bebida {
    public Chocolate() {
        super("Chocolate", 1500);
    }

    @Override
    public double calcularPrecio() {
        return getPrecioBase();
    }
}