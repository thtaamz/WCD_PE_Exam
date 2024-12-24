package org.example.exam_wcd.database;

import java.sql.*;

public class Database {
    private final String conectionString = "jdbc:mysql://localhost:3306/player_info";

    private final String user = "root";
    private final String password = "root";
    private final String driver = "com.mysql.cj.jdbc.Driver";

    //singleton pattern
    private static Database _instance;
    private Connection conn;
    private Database() {
        try {
            Class.forName(driver); // Load the driver
            conn = DriverManager.getConnection(conectionString,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load database driver: " + driver, e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database createInstance() {
        if (_instance == null) {
            synchronized (Database.class) {
                if (_instance == null) {
                    _instance = new Database();
                }
            }
        }
        return _instance;
    }
    public Statement getStatement() throws SQLException{
        return conn.createStatement();
    }
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
    public Connection getConnection() {
        return conn;
    }
}
