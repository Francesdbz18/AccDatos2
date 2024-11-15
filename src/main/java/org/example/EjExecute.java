package org.example;
import java.sql.*;

public class EjExecute {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitales", "CHESCADMIN", "1234");
            //construir orden CREATE VIEW
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE OR REPLACE VIEW totales ");
            sql.append("(dep, dnombre, nemp, media) AS ");
            sql.append("SELECT d.dept_no, dnombre, COUNT (emp_no), AVG(salario) ");
            sql.append("FROM departamentos d LEFT JOIN empleados e ");
            sql.append("ON e.dept_no = d.dept_no");
            sql.append("GROUP BY d.dept_no, dnombre ");
            System.out.println(sql);
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql.toString());
            System.out.printf("Resultado de la ejecución: %d %n", filas);
            conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }
}
