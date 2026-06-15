package test;

import cliente.Cliente;
import clienteDao.ClienteDao;

public class PruebaModificarCliente {
    public static void main(String[] args) {
    var clienteDao =new ClienteDao();
        System.out.println("*** Modificar cliente***");
    var modificarCliente = new Cliente(1,"Carlos","Ramiraz",100);
    var clienteModificado = clienteDao.modificarClienten(modificarCliente);
    if(clienteModificado){
        System.out.println("El cliente se ha modificado correctamente!!");
    }else {
        System.out.println("No se pudo modificar el cliente");
    }

    }
}
