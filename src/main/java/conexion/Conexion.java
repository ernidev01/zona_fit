package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase utilitaria para gestionar la conexión a la base de datos MySQL.
 * <p>
 * Proporciona un método estático para obtener una instancia de {@link Connection}
 * configurada con los parámetros del entorno local de desarrollo.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 */
public class Conexion {

    /**
     * Establece y retorna una conexión a la base de datos MySQL {@code zona_fit_db}.
     * <p>
     * Utiliza el driver {@code com.mysql.cj.jdbc.Driver} y se conecta al servidor
     * local en el puerto {@code 3306}. Si ocurre un error durante la conexión,
     * se imprime el mensaje en consola y se retorna {@code null}.
     * </p>
     *
     * @return una instancia de {@link Connection} si la conexión es exitosa,
     * o {@code null} si ocurre algún error.
     */
    public static Connection getConection() {
        Connection conexion = null;

        // Nombre de la base de datos a la que se desea conectar
        var baseDatos = "zona_fit_db";

        // URL de conexión JDBC apuntando al servidor MySQL local
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;

        // Credenciales de acceso al servidor de base de datos
        var usuario = "root";
        var password = "";

        try {
            // Carga explícita del driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión con los parámetros configurados
            conexion = DriverManager.getConnection(url, usuario, password);

        } catch (Exception e) {
            // Captura cualquier error de conexión o de carga del driver
            System.out.println("Error al conectarse con la base de datos: " + e.getMessage());
        }

        return conexion;
    }
}
