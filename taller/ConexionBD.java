import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConexionBD — Clase utilitaria de conexión JDBC.
 *
 * SRP: su única responsabilidad es entregar una conexión a la base de datos.
 *      No conoce entidades, no ejecuta queries, no maneja lógica de negocio.
 *
 * DIP: el resto del código (DAO, Main) depende de java.sql.Connection,
 *      no de esta clase concreta. Si mañana se cambia de MySQL a PostgreSQL,
 *      solo se modifica aquí.
 *
 * Uso:
 *      Connection conn = ConexionBD.getConnection();
 *      // ... trabajar con la conexión ...
 *      conn.close();
 */
public class ConexionBD {

    // --- Configuración: cambiar estos valores según el entorno ---

    // Para AWS RDS (usar en la sesión del taller):
    private static final String HOST = "poo-rds.cohm6s7qak4c.us-east-1.rds.amazonaws.com";

    // Para MySQL local (usar en la entrega final):
    // private static final String HOST = "localhost";

    private static final String PUERTO = "3306";
    private static final String BASE_DATOS = "poo_cafeteria";
    private static final String USUARIO = "admin";
    private static final String PASSWORD = "Poo2026rds"; // completar con la contraseña

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + BASE_DATOS;

    // Constructor privado — no se necesita instanciar esta clase
    private ConexionBD() {
    }

    /**
     * Retorna una nueva conexión a la base de datos.
     * El que la pide es responsable de cerrarla.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}