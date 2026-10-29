public class Detalle {
    private String producto;
    private  int cantidad;
    private  int precio;

    public Detalle(String producto, int cantidad, int precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int calcularSubtotal(){
        return cantidad * precio;
    }

    public void mostrar(){ 
        System.out.println(producto + ":"+ cantidad + "x" + precio + "=" + calcularSubtotal());
    }
}
