package Paso3_DIP;

// DIP: la abstracción que une bebidas y snacks
public interface Vendible {
    String getNombre();
    double calcularPrecio();
}