package test;

import conexion.Conexion;

public class PruebaConection {
    public static void main(String[] args) {
    var conexion = Conexion.getConection();
    if (conexion != null){
        System.out.println("Conexion exitosa");
    }
    else{
        System.out.println("Error de conexion");
    }
    }

}
