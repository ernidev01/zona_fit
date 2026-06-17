package clienteDao;

import cliente.Cliente;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de {@link IClienteDao} que gestiona el acceso a datos
 * de la entidad {@link Cliente} mediante JDBC sobre una base de datos MySQL.
 * <p>
 * Cada operación abre una sentencia preparada, ejecuta la consulta
 * correspondiente y cierra la conexión en el bloque {@code finally}.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see IClienteDao
 * @see conexion.Conexion
 */
public class ClienteDao implements IClienteDao {

    /** Sentencia SQL preparada para ejecutar consultas parametrizadas. */
    PreparedStatement ps;

    /** Conjunto de resultados obtenido tras ejecutar una consulta SELECT. */
    ResultSet rs;

    /** Conexión activa a la base de datos obtenida desde {@link Conexion}. */
    Connection conexion = Conexion.getConection();

    /**
     * Obtiene la lista completa de clientes registrados en la base de datos,
     * ordenados por su identificador.
     *
     * @return una {@link List} de objetos {@link Cliente},
     *         o una lista vacía si no hay registros o si ocurre un error.
     */
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        var select = "SELECT * FROM cliente ORDER BY idcliente";

        try {
            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            // Itera sobre los resultados y construye cada objeto Cliente
            while (rs.next()) {
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listas los clientes: " + e.getMessage());
        } finally {
            // Cierra la conexión al finalizar independientemente del resultado
            cerrarConexion();
        }

        return clientes;
    }

    /**
     * Busca un cliente en la base de datos por su ID y, si lo encuentra,
     * popula los datos del objeto recibido con la información del registro.
     *
     * @param cliente objeto {@link Cliente} que contiene el ID a buscar.
     *                Si se encuentra, sus atributos serán actualizados.
     * @return {@code true} si el cliente fue encontrado,
     *         {@code false} si no existe o si ocurre un error.
     */
    @Override
    public boolean buscarClinete(Cliente cliente) {
        var select = "SELECT * FROM cliente WHERE idcliente =?";

        try {
            ps = conexion.prepareStatement(select);

            // Asigna el ID del cliente como parámetro de la consulta
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                // Popula el objeto cliente con los datos encontrados en la BD
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            } else {
                System.out.println("No existe el cliente con el id: " + cliente.getId());
            }
        } catch (Exception e) {
            System.out.println("Error al buscaar el cliente por el id: " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return false;
    }

    /**
     * Inserta un nuevo cliente en la base de datos con los datos proporcionados.
     *
     * @param cliente objeto {@link Cliente} con el nombre, apellido y membresía
     *                a registrar. El ID es asignado automáticamente por la BD.
     * @return {@code true} si el cliente fue insertado exitosamente,
     *         {@code false} si ocurre un error.
     */
    @Override
    public boolean agregarClinete(Cliente cliente) {
        var insert = "INSERT INTO cliente (nombre, apellido, membresia) VALUES(?,?,?)";

        try {
            ps = conexion.prepareStatement(insert);

            // Asigna los valores del cliente como parámetros de la sentencia
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return false;
    }

    /**
     * Actualiza los datos de un cliente existente en la base de datos,
     * identificándolo por su ID.
     *
     * @param cliente objeto {@link Cliente} con el ID del registro a modificar
     *                y los nuevos valores de nombre, apellido y membresía.
     * @return {@code true} si el cliente fue modificado exitosamente,
     *         {@code false} si ocurre un error.
     */
    @Override
    public boolean modificarClienten(Cliente cliente) {
        var update = "UPDATE cliente SET nombre =?, apellido=?, membresia=? WHERE idcliente =?";

        try {
            ps = conexion.prepareStatement(update);

            // Asigna los nuevos valores y el ID como parámetros de la sentencia
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar El usuarioM " + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return false;
    }

    /**
     * Elimina un cliente de la base de datos identificándolo por su ID.
     *
     * @param cliente objeto {@link Cliente} que contiene el ID del registro
     *                a eliminar.
     * @return {@code true} si el cliente fue eliminado exitosamente,
     *         {@code false} si ocurre un error.
     */
    @Override
    public boolean eliminarCliente(Cliente cliente) {
        var delete = "DELETE FROM cliente WHERE idcliente =?";

        try {
            ps = conexion.prepareStatement(delete);

            // Asigna el ID del cliente como parámetro de la sentencia DELETE
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error, no se pudo eliminar cliente:" + e.getMessage());
        } finally {
            cerrarConexion();
        }

        return false;
    }

    /**
     * Cierra la conexión activa con la base de datos.
     * <p>
     * Este método es invocado en el bloque {@code finally} de cada operación
     * para garantizar la liberación de recursos independientemente del resultado.
     * </p>
     */
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}