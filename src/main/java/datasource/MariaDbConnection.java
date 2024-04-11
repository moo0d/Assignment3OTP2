package datasource;

import application.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Controller controller;

    private static Connection Mconnection = null;

    public static Connection getInstance() {
        if (Mconnection == null) {
            try {
                Mconnection = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/employee?user=root&password=root&characterEncoding=UTF-8");
            } catch (SQLException e) {
                handleSQLException(e);
            }
            return Mconnection;
        } else {
            return Mconnection;
        }
    }

    private static void handleSQLException(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("VendorError: " + e.getErrorCode());

    }
}
