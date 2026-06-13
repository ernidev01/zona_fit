package test;

import conexion.Conexion;

/**
 * Clase de prueba para verificar la conectividad con la base de datos.
 * <p>
 * Ejecuta una validación simple utilizando {@link conexion.Conexion#getConection()}
 * e imprime en consola el resultado de la conexión.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see conexion.Conexion
 */
public class PruebaConection {

    /**
     * Método principal de ejecución de la prueba de conexión.
     * <p>
     * Intenta obtener una conexión a la base de datos y notifica
     * en consola si fue exitosa o si ocurrió un error.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Intenta obtener la conexión a través de la clase utilitaria Conexion
        var conexion = Conexion.getConection();

        // Verifica si la conexión fue establecida correctamente
        if (conexion != null) {
            System.out.println("Conexion exitosa");
        } else {
            // Si la conexión es null, indica que hubo un fallo
            System.out.println("Error de conexion");
        }
    }
}
