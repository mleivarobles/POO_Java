/**
 * Producto — Entidad del dominio Cafetería.
 *
 * Encapsulamiento: atributos privados, acceso por getters/setters.
 * El id lo asigna la base de datos (AUTO_INCREMENT).
 */
public class Producto {

    private int id;
    private String nombre;
    private int precio;
    private String categoria;
    private int stock;

    // Constructor para crear un producto nuevo (sin id, lo asigna la BD)
    public Producto(String nombre, int precio, String categoria, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Constructor completo (para cuando se lee desde la BD)
    public Producto(int id, String nombre, int precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio
                + ", categoria='" + categoria + "', stock=" + stock + "}";
    }
}