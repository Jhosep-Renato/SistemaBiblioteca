package org.renato.sb.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String user = "root";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/Biblioteca";
    private static final String password = "truelove06";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
