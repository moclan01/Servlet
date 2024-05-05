package com.example.formnhapdulieu.dao;

import com.example.formnhapdulieu.model.User;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDAO implements InterfaceDAO<User> {
    public UserDAO() {

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                User user = new User(username,password,name,email);
                users.add(user);
            }
            JDBCUtils.closeConnection(conn,stmt,rs);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public boolean insert(User model) {
        int insertRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            String username = model.getUsername();
            String password = model.getPassword();
            String name = model.getName();
            String email = model.getEmail();
            String sql = "INSERT INTO users (username, password, name, email) VALUES(?,?,?,?)";

            PreparedStatement stmt  = conn.prepareStatement(sql);
            stmt.setObject(1,username);
            stmt.setObject(2,password);
            stmt.setObject(3,name);
            stmt.setObject(4,email);

            insertRows = stmt.executeUpdate();

            JDBCUtils.closeConnection(conn,stmt,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertRows > 0;
    }

    @Override
    public boolean update(User model) {
        int updateRows = 0;
        try{
            Connection conn = JDBCUtils.getConnection();
            String username = model.getUsername();
            String password = model.getPassword();
            String name = model.getName();
            String email = model.getEmail();
            String sql = "UPDATE users SET name = ?, email = ? WHERE username = ?";
            PreparedStatement stmt  = conn.prepareStatement(sql);
            stmt.setObject(1,name);
            stmt.setObject(2,email);
            stmt.setObject(3,username);
            
            updateRows = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn,stmt,null);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return updateRows > 0;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }

}
