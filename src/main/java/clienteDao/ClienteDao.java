package clienteDao;

import cliente.Cliente;
import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements IClienteDao{
    @Override
    public List<Cliente> listarClientes() {
        List <Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = Conexion.getConection();
        var select = "SELECT * FROM cliente ORDER BY id";
        try{
            ps= conexion.prepareStatement(select);
            rs = ps.executeQuery();
            while(rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("idcliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
            clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error al listas los clientes" +e.getMessage());
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion" +e.getMessage() );
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClinete(Cliente cliente) {
        return false;
    }

    @Override
    public boolean agregarClinete(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarClienten(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }
}
