// SRP: esta clase SOLO modela una bebida
public class Bebida {
    private String nombre;
    private double precioBase;
    private String tamanio;

    public Bebida(String nombre, double precioBase, String tamanio) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tamanio = tamanio;
    }

    public double calcularPrecio() {
        if (tamanio.equals("grande")) {
            return precioBase + 500;
        } else if (tamanio.equals("mediano")) {
            return precioBase + 300;
        } else {
            return precioBase;
        }
    }

    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public String getTamanio() { return tamanio; }
}