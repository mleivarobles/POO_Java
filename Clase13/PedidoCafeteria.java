public class PedidoCafeteria {
    
    private int numero;
    private Bebida[] items;
    private int cantidad;

    public PedidoCafeteria(int numero) {
        this.numero = numero;
        this.items = new Bebida[10];
        this.cantidad = 0;
    }

    public void agregar(Bebida bebida) {
        if (cantidad < items.length) {
            items[cantidad++] = bebida;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += items[i].calcularPrecio();
        }
        return total;
    }

    public void imprimirBoleta() {
        System.out.println("Pedido #" + numero);
        for (int i = 0; i < cantidad; i++) {
            System.out.println(items[i].generarBoleta());
        }
        System.out.println("TOTAL: $" + calcularTotal());
    }
}