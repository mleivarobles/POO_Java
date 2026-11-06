package Paso3_DIP;
// SRP: esta clase SOLO genera boletas
public class GeneradorBoleta {
    public String generar(String nombreItem, String detalle, double precio) {
        return "=== BOLETA CAFETERÍA ===\n" +
               "Producto: " + nombreItem + " (" + detalle + ")\n" +
               "Total: $" + precio + "\n" +
               "========================";
    }
}