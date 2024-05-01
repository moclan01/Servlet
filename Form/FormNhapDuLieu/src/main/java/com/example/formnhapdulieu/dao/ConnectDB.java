package com.example.formnhapdulieu.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;

public class ConnectDB {
    public  static Jdbi jdbi;
    public static final String HOST = "localhost";
    public static final String POST = "3306";
    public static final String DBName = "middlesemester";
    public static final String username = "root";

    public static final String password = "02012003Chihai";
    public static void createConnection(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://" + HOST +":" + POST + "/" + DBName);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        try {
            dataSource.setAutoReconnect(true);
            dataSource.setUseCompression(true);
        }catch (SQLException e){
            e.printStackTrace();
        }
        jdbi = Jdbi.create(dataSource);
    }

    public static Jdbi getJdbi(){
        if(jdbi == null){
            createConnection();
        }
        return jdbi;
    }
}
