import java.util.ArrayList;

public class Factura {

    private int numero;
    private String cliente;
    private ArrayList<Detalle> lineas; // a una lista con el detalle en vez de array. Almacenamiento dinamica

    public Factura(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.lineas = new ArrayList<>(); //no requiere tamaño maximo. Acá se crea la lista
    }

    //Composicion: la factura crea cada linea de detalle (producto) interntamente
    public void agregarProducto(String producto, int cant, int precio){
        Detalle linea = new Detalle(producto, cant, precio);
        lineas.add(linea); //agrego una linea de producto a la factura
    }

    public int calcularTotal(){
        int total = 0;
        for (Detalle producto : lineas) {
            total += producto.calcularSubtotal(); //sumo cada linea de detalle
        }
        return total;
    }

    public void mostrar(){
        System.out.println("Factura N°:" + numero);
        System.out.println("Cliente:" + cliente + " - Cantidad de Productos: " + lineas.size());
        System.out.println("Detalle:");
        for (Detalle linea : lineas) {
            linea.mostrar();
        }
    }
}
