public class Main {

    public static void main(String[] args) {
        Producto notebook = new Producto("Notebook HP", 599990, 5);
        Producto mouse = new Producto("Mouse Logitech", 29990, 20);
        Producto teclado = new Producto("Teclado Mecánico", 89990, 0);

        System.out.println(notebook);
        System.out.println(mouse);
        System.out.println(teclado);

        Carrito carrito = new Carrito();
        carrito.agregar(notebook, 2);
        carrito.agregar(mouse, 3);
        carrito.agregar(teclado, 1); // Intento de agregar un producto con stock 0

        System.out.println("\n " + carrito);

    }
}
