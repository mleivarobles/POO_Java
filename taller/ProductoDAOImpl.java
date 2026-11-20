import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductoDAOImpl — Implementación JDBC del CRUD de Producto.
 *
 * SRP: solo se encarga de persistir y recuperar productos.
 *      No gestiona la conexión (eso es de ConexionBD),
 *      no tiene lógica de negocio ni interfaz de usuario.
 *
 * DIP: implementa la interfaz ProductoDAO.
 *      Usa PreparedStatement para prevenir SQL Injection.
 */
public class ProductoDAOImpl implements ProductoDAO {

    // --- CREATE ---
    @Override
    public void crear(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, categoria, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getCategoria());
            ps.setInt(4, producto.getStock());
            ps.executeUpdate();

            System.out.println("Producto creado: " + producto.getNombre());

        } catch (SQLException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }
    }

    // --- READ (por id) ---
    @Override
    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM producto WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extraerProducto(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return null;
    }

    // --- READ (todos) ---
    @Override
    public List<Producto> listarTodos() {
        String sql = "SELECT * FROM producto";
        List<Producto> productos = new ArrayList<>();

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(extraerProducto(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        return productos;
    }

    // --- UPDATE ---
    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, categoria = ?, stock = ? WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getCategoria());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();

            System.out.println("Producto actualizado: " + producto.getNombre());

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    // --- DELETE ---
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Producto eliminado con id: " + id);

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    // Metodo auxiliar para extraer un Producto desde un ResultSet
    private Producto extraerProducto(ResultSet rs) throws SQLException {
        return new Producto(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getInt("precio"),
            rs.getString("categoria"),
            rs.getInt("stock")
        );
    }
}