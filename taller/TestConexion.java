// TestConexion.java
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.getConnection()) {
            System.out.println("Conexion exitosa: " + conn.getCatalog());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}