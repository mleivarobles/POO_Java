import java.util.List;

/**
 * ProductoDAO — Interfaz que define las operaciones CRUD.
 *
 * DIP: el código cliente (Main) depende de esta interfaz,
 *      no de la implementación concreta.
 *
 * OCP: si mañana se necesita un DAO que guarde en archivo o en otra BD,
 *      se crea una nueva implementación sin modificar esta interfaz
 *      ni el código que la usa.
 */
public interface ProductoDAO {

    void crear(Producto producto);

    Producto buscarPorId(int id);

    List<Producto> listarTodos();

    void actualizar(Producto producto);

    void eliminar(int id);
}