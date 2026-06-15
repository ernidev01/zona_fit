package clienteDao;

import cliente.Cliente;

import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para la gestión de clientes.
 * <p>
 * Establece el contrato que deben implementar las clases de acceso a datos
 * relacionadas con la entidad {@link cliente.Cliente} en el sistema Zona Fit.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see cliente.Cliente
 */
public interface IClienteDao {

    /**
     * Obtiene la lista completa de clientes registrados en la base de datos.
     *
     * @return una {@link List} de objetos {@link Cliente},
     *         o una lista vacía si no hay clientes registrados.
     */
    List<Cliente> listarClientes();

    /**
     * Busca un cliente en la base de datos por su información.
     *
     * @param cliente objeto {@link Cliente} con los datos a buscar.
     * @return {@code true} si el cliente fue encontrado, {@code false} en caso contrario.
     */
    boolean buscarClinete(Cliente cliente);

    /**
     * Registra un nuevo cliente en la base de datos.
     *
     * @param cliente objeto {@link Cliente} con los datos a insertar.
     * @return {@code true} si el cliente fue agregado exitosamente,
     *         {@code false} si ocurrió un error.
     */
    boolean agregarClinete(Cliente cliente);

    /**
     * Actualiza los datos de un cliente existente en la base de datos.
     *
     * @param cliente objeto {@link Cliente} con los datos actualizados.
     * @return {@code true} si el cliente fue modificado exitosamente,
     *         {@code false} si ocurrió un error.
     */
    boolean modificarClienten(Cliente cliente);

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param cliente objeto {@link Cliente} a eliminar.
     * @return {@code true} si el cliente fue eliminado exitosamente,
     *         {@code false} si ocurrió un error.
     */
    boolean eliminarCliente(Cliente cliente);
}