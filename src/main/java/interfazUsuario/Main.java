package interfazUsuario;

import cliente.Cliente;
import clienteDao.ClienteDao;

import java.util.Scanner;

/**
 * Clase principal de la interfaz de usuario del sistema Zona Fit.
 * <p>
 * Gestiona el menú interactivo por consola que permite al usuario
 * realizar operaciones CRUD sobre los clientes del gimnasio, utilizando
 * {@link clienteDao.ClienteDao} como capa de acceso a datos.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 * @see clienteDao.ClienteDao
 * @see cliente.Cliente
 */
public class Main {

    /** DAO encargado de las operaciones de acceso a datos de clientes. */
    static ClienteDao clienteDao = new ClienteDao();

    /** Scanner para leer la entrada del usuario desde la consola. */
    static Scanner consola = new Scanner(System.in);

    /**
     * Método principal de ejecución del sistema.
     * <p>
     * Muestra el menú principal en un bucle continuo hasta que el usuario
     * seleccione la opción de salir. Incluye validación de entrada para
     * asegurar que solo se acepten valores numéricos.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        int opcionMenu = 0;
        var salir = true;

        do {
            System.out.println("*** Bienvenido ***");
            System.out.println("""
                    Menu
                    1. Ver lista de clientes.
                    2. Buscar cliente.
                    3. Agregar cliente nuevo.
                    4. Modificar cliente.
                    5. Eliminar cliente.
                    6. salir.
                    """);

            // Valida que el usuario ingrese un valor numérico como opción del menú
            var verificacion = true;
            do {
                System.out.println();
                System.out.print("Por favor digite Una opcion:");
                try {
                    opcionMenu = Integer.parseInt(consola.nextLine());
                    verificacion = false;
                } catch (Exception e) {
                    verificacion = true;
                }
            } while (verificacion);

            // Ejecuta la opción seleccionada y determina si continuar o salir
            salir = menu(opcionMenu);
        } while (salir);
    }

    /**
     * Procesa la opción seleccionada por el usuario en el menú principal.
     *
     * @param opcionMenu número de opción ingresado por el usuario.
     * @return {@code true} para continuar mostrando el menú,
     *         {@code false} para salir del sistema.
     */
    private static boolean menu(int opcionMenu) {
        var salir = true;

        switch (opcionMenu) {
            case 1 -> mostrarListaClinetes();
            case 2 -> buscarCliente();
            case 3 -> agregarCliente();
            case 4 -> modificarCliente();
            case 5 -> eliminarCliente();
            case 6 -> salir = false; // El usuario elige salir del sistema
            default -> System.out.println("Por favor digite una opcion correcta");
        }

        return salir;
    }

    /**
     * Solicita un ID por consola y elimina el cliente correspondiente
     * de la base de datos.
     * <p>
     * Incluye validación de entrada para asegurar que el ID ingresado
     * sea un valor numérico.
     * </p>
     */
    private static void eliminarCliente() {
        System.out.println("*** Eliminar cliente ***");
        System.out.println();
        System.out.println("Por favor digite el id del cliente que quiere eliminar");

        boolean verificacion = true;
        int idCliente = 0;

        // Valida que el ID ingresado sea un valor numérico
        do {
            verificacion = true;
            try {
                idCliente = Integer.parseInt(consola.nextLine());
                verificacion = false;
            } catch (Exception e) {
                System.out.println("Por favor digite solo numeros");
                System.out.println();
            }
        } while (verificacion);

        // Crea el cliente con el ID ingresado y solicita su eliminación
        var borrarCliente = new Cliente(idCliente);
        clienteDao.eliminarCliente(borrarCliente);
    }

    /**
     * Solicita los datos de un nuevo cliente por consola y lo registra
     * en la base de datos.
     * <p>
     * Incluye validación de entrada para el campo membresía, asegurando
     * que sea un valor numérico.
     * </p>
     */
    private static void agregarCliente() {
        String nombre;
        String apellido;
        int membresia = 0;

        System.out.println("*** Agregar cliente ***");
        System.out.println();

        // Solicita el nombre y apellido del nuevo cliente
        System.out.print("Digite el nombre del cliente: ");
        nombre = consola.nextLine();

        System.out.print("Digite apellido del cliente: ");
        apellido = consola.nextLine();

        // Valida que el número de membresía ingresado sea numérico
        System.out.print("Digite numero de membresia del cliente: ");
        boolean verificacion;
        do {
            verificacion = true;
            try {
                membresia = Integer.parseInt(consola.nextLine());
                verificacion = false;
            } catch (Exception e) {
                System.out.println("Por favor digite solo numeros");
                System.out.println();
            }
        } while (verificacion);

        // Crea el cliente con los datos ingresados y lo registra en la base de datos
        var cliente = new Cliente(nombre, apellido, membresia);
        clienteDao.agregarClinete(cliente);
    }

    /**
     * Solicita un ID por consola y busca el cliente correspondiente
     * en la base de datos.
     * <p>
     * Incluye validación de entrada para asegurar que el ID ingresado
     * sea un valor numérico.
     * </p>
     */
    private static void buscarCliente() {
        int idCliente = 0;
        boolean verificacion;

        // Valida que el ID ingresado sea un valor numérico
        do {
            System.out.println();
            System.out.println("*** Buscar cliente por id ***");
            System.out.println();
            System.out.print("Por favor digite id: ");
            verificacion = true;
            try {
                idCliente = Integer.parseInt(consola.nextLine());
                verificacion = false;
            } catch (Exception e) {
                verificacion = true;
            }
        } while (verificacion);

        // Crea el cliente con el ID ingresado y ejecuta la búsqueda
        System.out.println();
        var cliente = new Cliente(idCliente);
        clienteDao.buscarClinete(cliente);
    }

    /**
     * Solicita por consola el ID y los nuevos datos de un cliente,
     * y aplica los cambios en la base de datos.
     * <p>
     * Incluye validación de entrada para los campos numéricos
     * (ID y membresía).
     * </p>
     */
    private static void modificarCliente() {
        System.out.println("*** Modificar cliente ***");
        System.out.println();

        String nombre;
        String apellido;
        int membresia = 0;
        int idCliente = 0;

        // Valida que el ID del cliente a modificar sea un valor numérico
        System.out.print("Digite el numero de id del cliente que desea modificar: ");
        boolean verificacion;
        do {
            verificacion = true;
            try {
                idCliente = Integer.parseInt(consola.nextLine());
                verificacion = false;
            } catch (Exception e) {
                System.out.println("Por favor digite solo numeros");
                System.out.println();
            }
        } while (verificacion);

        // Solicita los nuevos datos del cliente
        System.out.print("Digite el nombre del cliente modificado: ");
        nombre = consola.nextLine();

        System.out.print("Digite apellido del cliente modificado: ");
        apellido = consola.nextLine();

        // Valida que el nuevo número de membresía sea numérico
        System.out.print("Digite numero de membresia del cliente modificado: ");
        do {
            verificacion = true;
            try {
                membresia = Integer.parseInt(consola.nextLine());
                verificacion = false;
            } catch (Exception e) {
                System.out.println("Por favor digite solo numeros");
                System.out.println();
            }
        } while (verificacion);

        // Crea el cliente actualizado y aplica los cambios en la base de datos
        var clioenteModificado = new Cliente(idCliente, nombre, apellido, membresia);
        clienteDao.modificarClienten(clioenteModificado);
    }

    /**
     * Obtiene y muestra en consola la lista completa de clientes
     * registrados en la base de datos.
     */
    private static void mostrarListaClinetes() {
        System.out.println("*** Listar clientes ***");
        System.out.println();

        // Obtiene y muestra todos los clientes registrados
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println();
    }
}