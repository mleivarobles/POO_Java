package Paso3_DIP;

// Snack también implementa Vendible
public class Snack implements Vendible {
    private String nombre;
    private double precio;

    public Snack(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double calcularPrecio() { return precio; }
}