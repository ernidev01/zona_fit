package test;

import cliente.Cliente;
import clienteDao.ClienteDao;

/**
 * Clase de prueba para verificar la modificación de un cliente existente.
 * <p>
 * Crea un objeto {@link Cliente} con los nuevos datos a actualizar y
 * utiliza {@link clienteDao.ClienteDao#modificarClienten(Cliente)} para
 * aplicar los cambios en la base de datos, mostrando el resultado en consola.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see cliente.Cliente
 * @see clienteDao.ClienteDao
 */
public class PruebaModificarCliente {

    /**
     * Método principal de ejecución de la prueba de modificación de cliente.
     * <p>
     * Crea un cliente de prueba con ID = 1 y nuevos valores de nombre,
     * apellido y membresía, solicita su actualización a través de
     * {@link ClienteDao} y notifica en consola si la operación fue
     * exitosa o no.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Instancia del DAO encargado del acceso a datos de Cliente
        var clienteDao = new ClienteDao();

        System.out.println("*** Modificar cliente***");

        // Crea un cliente de prueba con los nuevos datos a actualizar
        var modificarCliente = new Cliente(1, "Carlos", "Ramiraz", 100);

        // Ejecuta la modificación del cliente en la base de datos
        var clienteModificado = clienteDao.modificarClienten(modificarCliente);

        // Verifica si la modificación fue exitosa y notifica el resultado
        if (clienteModificado) {
            System.out.println("El cliente se ha modificado correctamente!!");
        } else {
            System.out.println("No se pudo modificar el cliente");
        }
    }
}