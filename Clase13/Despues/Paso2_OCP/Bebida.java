package Paso2_OCP;

// OCP: clase base con comportamiento común
public abstract class Bebida {
    private String nombre;
    private double precioBase;

    public Bebida(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Cada subclase define su propio cálculo
    public abstract double calcularPrecio();

    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
}

