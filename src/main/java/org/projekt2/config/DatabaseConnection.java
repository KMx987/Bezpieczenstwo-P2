package org.projekt2.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static String url =
            "jdbc:postgresql://localhost:5432/securedb";

    private static String user;
    private static String password;

    public static void init(String u, String p) {
        user = u;
        password = p;
    }

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
}
