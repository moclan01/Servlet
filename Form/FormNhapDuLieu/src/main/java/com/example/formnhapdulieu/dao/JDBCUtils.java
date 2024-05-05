package com.example.formnhapdulieu.dao;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection(){
        Connection c = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url = "jdbc:mysql://localhost:3306/seminar";
            String username = "root";
            String password = "";

            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
