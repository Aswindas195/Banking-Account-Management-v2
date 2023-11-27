package org.aswinayyappadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String JDBC_URL = "jdbc:postgresql://your-postgresql-host:your-postgresql-port/your-database-name";
    private static final String USERNAME = "your-username";
    private static final String PASSWORD = "your-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
