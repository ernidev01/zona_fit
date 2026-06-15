package test;

import cliente.Cliente;
import clienteDao.ClienteDao;

/**
 * Clase de prueba para verificar la búsqueda de un cliente por su ID.
 * <p>
 * Crea un objeto {@link Cliente} con un ID específico y utiliza
 * {@link clienteDao.ClienteDao#buscarClinete(Cliente)} para
 * comprobar su existencia en la base de datos.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see cliente.Cliente
 * @see clienteDao.ClienteDao
 */
public class PruevaBuscarClientePorId {

    /**
     * Método principal de ejecución de la prueba de búsqueda de cliente.
     * <p>
     * Crea un cliente de prueba con ID = 10 y solicita su búsqueda
     * a través de {@link ClienteDao}.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("*** Buscar por id ***");

        // Crea un cliente de prueba utilizando solo el ID a buscar
        var cliente = new Cliente(10);

        // Instancia del DAO encargado del acceso a datos de Cliente
        var clienteDao = new ClienteDao();

        // Ejecuta la búsqueda del cliente por ID en la base de datos
        clienteDao.buscarClinete(cliente);
    }
}