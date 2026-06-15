package test;

import cliente.Cliente;
import clienteDao.ClienteDao;

public class PruebaAgregarCliente {
    public static void main(String[] args) {
        var clienteDao = new ClienteDao();
        var nuevoCliente = new Cliente("Pepitp", "Perez", 100);
        var clienteAgregado = clienteDao.agregarClinete(nuevoCliente);
        if (clienteAgregado){
            System.out.println("El cliente se ha agregado correctamente !!!");
        }else {
            System.out.println("El cliente no se agrego");
        }
    }
}
