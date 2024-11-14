package org.example;
import java.sql.*;

public class Metadatos {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitales", "hospitadmin", "12345678");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul;
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS: ");
            System.out.println("============== ====================");
            System.out.printf("Nombre: %s %n", nombre);
            System.out.printf("Driver: %s %n", driver);
            System.out.printf("URL : %s %n", url);
            System.out.printf("Usuario: %s in ", usuario);
            resul = dbmd.getTables(null, "hospitales", null, null);
            while (resul.next()) {
                String catalogo =  resul.getString(1);
                String esquema = resul.getString (2);
                String tabla = resul.getString(3);
                String tipo = resul.getString(4);
                System.out.printf("%s Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }
}
