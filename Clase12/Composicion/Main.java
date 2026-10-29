public class Main {
    public static void main(String[] args) {
        
        Factura factura = new Factura(57363434, "UMC");

        //factura.mostrar();
        factura.agregarProducto(" - Sillas", 3, 5000);
        factura.agregarProducto(" - Mesas", 1, 7000);
        factura.agregarProducto(" - Comedor", 4, 6000);
        factura.agregarProducto(" - Sofa", 8, 3000);
        factura.agregarProducto(" - Librero", 2, 4400);
        factura.mostrar();
        //factura = null;

    }
}
