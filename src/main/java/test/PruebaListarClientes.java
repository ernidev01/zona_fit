package test;

import clienteDao.ClienteDao;

/**
 * Clase de prueba para verificar el listado completo de clientes.
 * <p>
 * Utiliza {@link clienteDao.ClienteDao#listarClientes()} para obtener
 * todos los clientes registrados en la base de datos y los imprime
 * en consola.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see clienteDao.ClienteDao
 */
public class PruebaListarClientes {

    /**
     * Método principal de ejecución de la prueba de listado de clientes.
     * <p>
     * Obtiene la lista completa de clientes a través de {@link ClienteDao}
     * y muestra cada uno de ellos en consola.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("*** Listar clientes ***");

        // Instancia del DAO encargado del acceso a datos de Cliente
        var clienteDao = new ClienteDao();

        // Obtiene la lista completa de clientes desde la base de datos
        var clientes = clienteDao.listarClientes();

        // Imprime cada cliente de la lista en consola
        clientes.forEach(System.out::println);
    }
}