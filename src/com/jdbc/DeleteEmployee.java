package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {

    public static void main(String[] args) {

        String sql = """
                DELETE FROM employees
                WHERE employee_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            int targetEmployeeId = 1;

            ps.setInt(1, targetEmployeeId);

            int rowsAffected = ps.executeUpdate();

            System.out.println(rowsAffected + " employee deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}