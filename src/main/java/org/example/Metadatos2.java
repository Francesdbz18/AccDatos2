package org.example;
import java.sql.*;

public class Metadatos2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitales", "CHESCADMIN", "1234");
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
            resul = dbmd.getColumns(null, "CHESCADMIN", "emp", null);
            while (resul.next()) {
                String catalogo =  resul.getString(4);
                String esquema = resul.getString (6);
                String tabla = resul.getString(7);
                String tipo = resul.getString(18);
                System.out.printf("%s Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
            resul = dbmd.getPrimaryKeys(null, "CHESCADMIN", "emp");
            while (resul.next()) {
                String catalogo =  resul.getString(4);
                String esquema = resul.getString (6);
                String tabla = resul.getString(7);
                String tipo = resul.getString(18);
                System.out.printf("%s Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }

            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }
}
