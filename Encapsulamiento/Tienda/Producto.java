public class Producto {
    
    //todos los atributos son privados para que no se pueda acceder a ellos desde fuera de la clase
    private String nombre;
    private double precio;
    private int stock;
    private boolean activo;

    //Constructor con validaciones
    public Producto(String nombre, double precio, int stock) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        this.activo = true; // Por defecto, el producto está activo al crearse
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }else {
            System.out.println("El nombre no puede estar vacío o ser nulo: " + nombre);
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser un valor positivo: " + precio);
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock no puede ser negativo: " + stock);
        }
    }

    @Override
    public String toString() {
        //String estado = activo ? "Activo" : "Inactivo"; //es equivalente a la siguiente estructura if-else
        String estado;
        if (activo) {
            estado = "Activo";
        }else{
            estado = "Inactivo";
        }
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", activo=" + estado + "]";
    }

    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
