package test;

import cliente.Cliente;
import clienteDao.ClienteDao;

/**
 * Clase de prueba para verificar la eliminación de un cliente.
 * <p>
 * Crea un objeto {@link Cliente} con el ID del registro a eliminar y
 * utiliza {@link clienteDao.ClienteDao#eliminarCliente(Cliente)} para
 * realizar la eliminación en la base de datos, mostrando el resultado
 * en consola.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see cliente.Cliente
 * @see clienteDao.ClienteDao
 */
public class PruebaEliminarCliente {

    /**
     * Método principal de ejecución de la prueba de eliminación de cliente.
     * <p>
     * Crea un cliente de prueba con ID = 1, solicita su eliminación a
     * través de {@link ClienteDao} y notifica en consola si la operación
     * fue exitosa o no.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Instancia del DAO encargado del acceso a datos de Cliente
        var clienteDao = new ClienteDao();

        // Crea un cliente de prueba utilizando solo el ID a eliminar
        var eliminarCliente = new Cliente(1);

        // Ejecuta la eliminación del cliente en la base de datos
        var clienteEliminado = clienteDao.eliminarCliente(eliminarCliente);

        // Verifica si la eliminación fue exitosa y notifica el resultado
        if (clienteEliminado) {
            System.out.println("El cliente se ha eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el cliente");
        }
    }
}