public class Main {
    
    public static void main(String[] args) {
        Factura factura = new Factura(762311, "UMC");
        
        factura.agregarProducto("Notebook", 4, 15000);
        factura.agregarProducto("Mouse", 3, 4000);
        factura.agregarProducto("Pantalla", 10, 3000);
        factura.agregarProducto("Teclado", 8, 10000);
        factura.mostrar();
    }
}
