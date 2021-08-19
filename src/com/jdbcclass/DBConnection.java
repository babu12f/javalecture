package com.jdbcclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/javaclass";
    private static final String DBUSERNAME = "root";
    private static final String DBPASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
    }
}
