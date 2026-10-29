public class Detalle {

    private String producto;
    private int cantidad;
    private int precio;

    public Detalle(String producto, int cantidad, int precio) {
        this.producto = producto; //sillas
        this.cantidad = cantidad; // 4
        this.precio = precio; // 5000 -> 12000
    }

    public int subtotal(){
        return  cantidad * precio;
    }

    public void mostrar(){
        System.out.println(producto + ":" + cantidad +" x " + precio + "=" + subtotal());
    }
}
