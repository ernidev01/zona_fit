package cliente;

import java.util.Objects;

/**
 * Representa un cliente del gimnasio Zona Fit.
 * <p>
 * Contiene la información básica del cliente como su identificador,
 * nombre, apellido y el tipo de membresía contratada.
 * </p>
 *
 * @author Erick Gonzalez
 * @version 1.0
 */
public class Cliente {

    /** Identificador único del cliente en la base de datos. */
    private int id;

    /** Nombre del cliente. */
    private String nombre;

    /** Apellido del cliente. */
    private String apellido;

    /** Identificador del tipo de membresía del cliente. */
    private int membresia;

    /**
     * Constructor vacío. Crea un cliente sin inicializar ningún atributo.
     */
    public Cliente() {}

    /**
     * Constructor que inicializa el cliente solo con su identificador.
     * Útil para búsquedas o eliminaciones por ID.
     *
     * @param id identificador único del cliente.
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa un cliente sin ID.
     * Útil para registrar un nuevo cliente antes de asignarle un ID.
     *
     * @param nombre    nombre del cliente.
     * @param apellido  apellido del cliente.
     * @param membresia identificador del tipo de membresía.
     */
    public Cliente(String nombre, String apellido, int membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    /**
     * Constructor completo que inicializa todos los atributos del cliente.
     *
     * @param id        identificador único del cliente.
     * @param nombre    nombre del cliente.
     * @param apellido  apellido del cliente.
     * @param membresia identificador del tipo de membresía.
     */
    public Cliente(int id, String nombre, String apellido, int membresia) {
        this(nombre, apellido, membresia);
        this.id = id;
    }

    /**
     * Retorna el identificador único del cliente.
     *
     * @return el ID del cliente.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el identificador de la membresía del cliente.
     *
     * @return el ID de la membresía.
     */
    public int getMembresia() {
        return membresia;
    }

    /**
     * Retorna el nombre del cliente.
     *
     * @return el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el apellido del cliente.
     *
     * @return el apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el tipo de membresía del cliente.
     *
     * @param membresia nuevo identificador de membresía.
     */
    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param apellido nuevo apellido del cliente.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna una representación en cadena del cliente con todos sus atributos.
     *
     * @return cadena con el formato {@code Cliente{id, nombre, apellido, membresia}}.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    /**
     * Compara este cliente con otro objeto para determinar si son iguales.
     * Dos clientes son iguales si comparten el mismo ID, nombre, apellido y membresía.
     *
     * @param o objeto a comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membresia == cliente.membresia
                && Objects.equals(nombre, cliente.nombre)
                && Objects.equals(apellido, cliente.apellido);
    }

    /**
     * Genera un código hash basado en todos los atributos del cliente.
     *
     * @return el valor hash del cliente.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membresia);
    }
}