package dao;

import datasource.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public void insertUser(String tableName, String firstName, String lastName, String email) {
        String sql = "INSERT INTO " + tableName + " (first_name, last_name, email) VALUES (?, ?, ?)";
        Connection connection = MariaDbConnection.getInstance();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
        }
    }
}