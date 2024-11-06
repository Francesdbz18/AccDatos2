package org.example;

import java.sql.*;

public class SQLito {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/Users/aludam2/sqlite/ejemplo.db");
            Statement statement = conexion.createStatement();
            String query = "select * from departamentos";
            ResultSet resultado = statement.executeQuery(query);
            while (resultado.next()) {
                System.out.println(resultado);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
