public class Bebida {
    private String nombre;
    private double precioBase;
    private String tamanio; // "pequeño", "mediano", "grande"

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

    public String generarBoleta() {
        return "=== BOLETA CAFETERÍA ===\n" +
               "Producto: " + nombre + " (" + tamanio + ")\n" +
               "Total: $" + calcularPrecio() + "\n" +
               "========================";
    }

    public void notificarMeson() {
        System.out.println(">>> MESÓN: " + nombre + " " + tamanio + " listo para entregar");
    }

    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public String getTamanio() { return tamanio; }
}