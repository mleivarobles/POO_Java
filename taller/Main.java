import java.util.List;

/**
 * Main — Demuestra el CRUD completo usando el patrón DAO.
 *
 * DIP en acción: Main trabaja con ProductoDAO (interfaz),
 * no con ProductoDAOImpl directamente.
 */
public class Main {

    public static void main(String[] args) {

        // DIP: la variable es de tipo interfaz
        ProductoDAO dao = new ProductoDAOImpl();

        System.out.println("========================================");
        System.out.println("  TALLER INTEGRADOR — CRUD Cafetería");
        System.out.println("========================================\n");

        // --- CREATE ---
        System.out.println("--- CREATE ---");
        Producto nuevo = new Producto("Té Verde", 1300, "Bebida caliente", 40);
        dao.crear(nuevo);

        // --- READ (todos) ---
        System.out.println("\n--- READ (listar todos) ---");
        List<Producto> productos = dao.listarTodos();
        for (Producto p : productos) {
            System.out.println(p);
        }

        // --- READ (por id) ---
        System.out.println("\n--- READ (buscar por id) ---");
        Producto encontrado = dao.buscarPorId(1);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        }

        // --- UPDATE ---
        System.out.println("\n--- UPDATE ---");
        if (encontrado != null) {
            encontrado.setPrecio(1800);
            encontrado.setStock(45);
            dao.actualizar(encontrado);

            // Verificar el cambio
            Producto verificado = dao.buscarPorId(encontrado.getId());
            System.out.println("Despues de actualizar: " + verificado);
        }

        // --- DELETE ---
        System.out.println("\n--- DELETE ---");
        dao.eliminar(nuevo.getId() > 0 ? nuevo.getId() : productos.size());

        // Verificar estado final
        System.out.println("\n--- Estado final de la tabla ---");
        List<Producto> finales = dao.listarTodos();
        for (Producto p : finales) {
            System.out.println(p);
        }

        System.out.println("\n========================================");
        System.out.println("  FIN DEL TALLER");
        System.out.println("========================================");
    }
}