package org.example;
import java.sql.*;

public class Metadatos3 {
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
            resul = dbmd.getProcedures(null, "hospitales", null);
            while (resul.next()) {
                String catalogo =  resul.getString("PROCEDURE_NAME");
                System.out.printf("%s POLLA\n", catalogo);
            }

            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }
}
