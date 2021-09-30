package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQLite implements ApplicationDbConnection {
    private static final String DBURL = "jdbc:sqlite:C:/temp/db/javaclass.db";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL);
    }
}
