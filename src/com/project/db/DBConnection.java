package com.project.db;

public class DBConnection {

    public static ApplicationDbConnection getDbConnection() {
        ApplicationDbConnection connection = new DBConnectionSQLite();
        return connection;
    }
}
