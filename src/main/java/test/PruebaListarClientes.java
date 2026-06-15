package test;

import clienteDao.ClienteDao;

public class PruebaListarClientes {
    public static void main(String[] args) {
        System.out.println("*** Listar clientes ***");
        var clienteDao = new ClienteDao();
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
    }
}
