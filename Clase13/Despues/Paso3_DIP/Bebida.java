package Paso3_DIP;

// Bebida implementa Vendible
public abstract class Bebida implements Vendible {
    private String nombre;
    private double precioBase;

    public Bebida(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
}



