package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {

    public static void main(String[] args) {
     
        String sql = """
                UPDATE employees
                SET salary = ?
                WHERE employee_id = ?
                """;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, 76000);
            ps.setInt(2, 2);
            int rows=ps.executeUpdate();
            System.out.println(rows + " employee updated.");
            
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}