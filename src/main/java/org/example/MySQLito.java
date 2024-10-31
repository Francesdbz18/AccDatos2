package org.example;
import java.sql.*;

public class MySQLito {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba1", "prueba1", "prueba1");
            Statement statement = conexion.createStatement();
            String query = "select * from asignatura";
            ResultSet resultado = statement.executeQuery(query);
            while (resultado.next()) {
                System.out.println(resultado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
