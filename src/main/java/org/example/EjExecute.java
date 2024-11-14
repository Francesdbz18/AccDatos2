package org.example;
import java.sql.*;

public class EjExecute {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitales", "CHESCADMIN", "1234");
            String sql = "SELECT FROM dept";
            Statement sentencia = boolean valor conexion.createStatement(); sentencia.execute(sql); if (valor) { ResultSet rs sentencia.getResultSet(); while (rs.next()) System.out.printf("%d, %s, %s %n", rs.getInt(1), rs.getString(2), rs.getString(3)); rs.close(); } else { int f sentencia.getUpdateCount(); System.out.printf("Filas afectadas:%d %n", f); } sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }
}
