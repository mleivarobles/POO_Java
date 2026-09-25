public class Carrito {
    
    private Producto[] items;
    private int[] cantidadItems;
    private int totalItems;

    public Carrito() {
        this.items = new Producto[10]; //10 productos como máximo
        this.cantidadItems = new int[10]; //10 cantidades como máximo
        this.totalItems = 0;
    }

    public void agregar(Producto producto, int cantidad) {
        if (totalItems < 10 && producto.isActivo()) {
            items[totalItems] = producto;
            cantidadItems[totalItems] = cantidad;
            totalItems++;
            System.out.println("Producto agregado al carrito: " + cantidad + " de " + producto.getNombre());
        } else if (!producto.isActivo()) {
            System.out.println("No se puede agregar un producto inactivo al carrito: " + producto.getNombre());
        } else {
            System.out.println("No se pueden agregar más productos al carrito.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < totalItems; i++) {
            total += items[i].getPrecio() * cantidadItems[i];
        }
        return total;
    }

    @Override
    public String toString() {
        String resultado = "Carrito [\n";
        for (int i = 0; i < totalItems; i++) {
            resultado += "  Producto: " + items[i].getNombre() + ", Cantidad: " + cantidadItems[i] + "\n";
        }
        resultado += "]: Total a pagar: " + calcularTotal();
        return resultado;
    }
}
