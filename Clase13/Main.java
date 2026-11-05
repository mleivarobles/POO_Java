public class Main {
    public static void main(String[] args) {
        Bebida cafe = new Bebida("Café", 1200, "grande");
        Bebida te = new Bebida("Té", 900, "mediano");
        Bebida cafe2 = new Bebida("Café", 800, "pequeño");

        PedidoCafeteria pedido = new PedidoCafeteria(1);
        pedido.agregar(cafe);
        pedido.agregar(te);
        pedido.agregar(cafe2);
        pedido.imprimirBoleta();
    }
}