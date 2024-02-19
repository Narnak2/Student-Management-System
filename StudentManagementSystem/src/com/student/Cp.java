package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cp {
    static Connection con;

    public static Connection createC() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection
            String user = "root";
            String password = "kanz8]WgUmEv~(7";
            String url = "jdbc:mysql://localhost:3306/StudentManagementSystem";

            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions more gracefully, log or provide a meaningful error message
            e.printStackTrace();
        }

        return con;
    }

    // You can add a closeConnection method if needed
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
