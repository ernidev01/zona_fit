package clienteDao;

import cliente.Cliente;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements IClienteDao {
    PreparedStatement ps;
    ResultSet rs;
    Connection conexion = Conexion.getConection();

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        var select = "SELECT * FROM cliente ORDER BY idcliente";
        try {
            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();
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
            cerrarConexion();
        }
        return clientes;
    }

    @Override
    public boolean buscarClinete(Cliente cliente) {
        var select = "SELECT * FROM cliente WHERE idcliente =?";
        try {
            ps = conexion.prepareStatement(select);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
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

    @Override
    public boolean agregarClinete(Cliente cliente) {
        var insert = "INSERT INTO cliente (nombre, apellido, membresia) VALUES(?,?,?)";
        try {
            ps = conexion.prepareStatement(insert);
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

    @Override
    public boolean modificarClienten(Cliente cliente) {
        var update= "UPDATE cliente SET nombre =?, apellido=?,membresia=? WHERE idcliente =?";
        try{
            ps = conexion.prepareStatement(update);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4,cliente.getId());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error al modificar El usuarioM "+e.getMessage());
        }
        finally {
            cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
