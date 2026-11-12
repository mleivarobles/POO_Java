package Paso3_DIP;

public class Main {
    public static void main(String[] args) {
        // DIP: declarados como Vendible, no como tipo concreto
        Vendible cafe = new Cafe("grande");
        Vendible te = new Te(true);
        Vendible muffin = new Snack("Muffin", 1800);
        Vendible galleta = new Snack("Galleta", 800);

        PedidoCafeteria pedido = new PedidoCafeteria(1);
        pedido.agregar(cafe);
        pedido.agregar(te);
        pedido.agregar(muffin);   // ✅ Snack entra sin modificar PedidoCafeteria
        pedido.agregar(galleta);

        // SRP: el pedido calcula, la boleta la genera otro
        GeneradorBoleta boleta = new GeneradorBoleta();
        NotificadorMeson meson = new NotificadorMeson();

        System.out.println("Pedido #1");
        for (int i = 0; i < 4; i++) {
            Vendible item = pedido.getItem(i);
            System.out.println(boleta.generar(
                item.getNombre(), "", item.calcularPrecio()));
        }
        System.out.println("TOTAL: $" + pedido.calcularTotal());

        meson.notificar("Pedido #1 listo para entregar");
    }
}