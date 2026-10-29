import java.util.ArrayList;

public class Factura {

    private int numero;
    private String cliente;
    private ArrayList<Detalle> lineas; //creando un lista dinamica y cada nodo (linea) tiene productos
    
    public Factura(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.lineas = new ArrayList<>(); // producto+cantidad+precio. tiene n lineas.
    }

    public void agregarProducto(String producto, int cant, int precio){
        Detalle linea = new Detalle(producto, cant, precio);
        lineas.add(linea); //agrega elementos a un lista
    }

    public int calcularTotal(){
        int total = 0;
        for (Detalle producto : lineas) { //en cada recorrido del for 
            total = total + producto.subtotal(); //sumo cada linea de detalle de mi favtura.
        }
        return total;
    }

    public void mostrar(){
        System.out.println("Factura N°: " + numero);
        System.out.println("Cliente:" + cliente);
        System.out.println("Cantidad de productos: " + lineas.size());
        System.out.println("Detalle:");
        for (Detalle linea : lineas) {
            linea.mostrar();
        }
    }
}
