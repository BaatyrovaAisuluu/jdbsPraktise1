package com.company.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String unl = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "1234";





    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(unl, user, password);
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


}
