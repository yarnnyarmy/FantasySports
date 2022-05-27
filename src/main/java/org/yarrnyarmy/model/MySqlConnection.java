package org.yarrnyarmy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private String getUsername() {
        String username = "root";
        return username;
    }

    private String getPassword() {
        String password = "Jabbo@0101";
        return password;
    }

    private String getJdbcURL() {
        String jdbcURL = "jdbc:mysql://localhost:3306/fantasy_sports";
        return jdbcURL;
    }

    public Connection sqlConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(getJdbcURL(), getUsername(), getPassword());
        return conn;
    }
}
