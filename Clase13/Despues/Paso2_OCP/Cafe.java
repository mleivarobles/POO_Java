package Paso2_OCP;

// OCP: nuevo tipo sin modificar Bebida
public class Cafe extends Bebida {
    private String tamanio;

    public Cafe(String tamanio) {
        super("Café", 1200);
        this.tamanio = tamanio;
    }

    @Override
    public double calcularPrecio() {
        if (tamanio.equals("grande")) return getPrecioBase() + 500;
        if (tamanio.equals("mediano")) return getPrecioBase() + 300;
        return getPrecioBase();
    }
}