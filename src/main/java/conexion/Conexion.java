package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConection(){
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url="jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // clase de conexion a la base de datos
            conexion= DriverManager.getConnection(url,usuario,password);

        }catch (Exception e){
            System.out.println("Error al conectarse con la base de datos" + e.getMessage());
        }

        return conexion;
    }
}
