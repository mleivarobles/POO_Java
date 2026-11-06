package Paso3_DIP;
// DIP: PedidoCafeteria depende de Vendible, no de Bebida
public class PedidoCafeteria {
    private int numero;
    private Vendible[] items; // ✅ Abstracción, no tipo concreto
    private int cantidad;

    public PedidoCafeteria(int numero) {
        this.numero = numero;
        this.items = new Vendible[10];
        this.cantidad = 0;
    }

    public void agregar(Vendible item) {
        if (cantidad < items.length) {
            items[cantidad++] = item;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += items[i].calcularPrecio();
        }
        return total;
    }

   public Vendible getItem(int i) { 
    return items[i]; 
    }

    public int getCantidad() { 
    return cantidad; 
    }
}