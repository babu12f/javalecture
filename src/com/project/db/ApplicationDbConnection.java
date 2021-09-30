package com.project.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ApplicationDbConnection {
    Connection getConnection() throws SQLException;
}
