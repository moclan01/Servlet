package com.example.formnhapdulieu.dao;

import com.example.formnhapdulieu.model.Log;
import com.example.formnhapdulieu.model.Product;
import com.example.formnhapdulieu.model.User;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleCallback;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LogDAO implements InterfaceDAO<Log> {
    public LogDAO() {
    }

    @Override
    public List<Log> getAll() {
        List<Log> logs = new ArrayList<>();
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM logs";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String action = rs.getString("action");
                String level = rs.getString("level");
                String user = rs.getString("user");
                String time = rs.getString("time");
                String ip = rs.getString("ip");
                String value = rs.getString("value");
                Log log = new Log(id,action,level,user,time,ip,value);
                logs.add(log);
            }
            JDBCUtils.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logs;
    }

    @Override
    public boolean insert(Log model) {
        int insertRow = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
        String action = model.getAction();
        String level = model.getLevel();
        String user = model.getUsername();
        String ip = model.getIp();
        String value = model.getValue();
        String sql ="INSERT INTO logs(action, level, user, ip, value,isDelete) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1,action);
            stmt.setObject(2,level);
            stmt.setObject(3,user);
            stmt.setObject(4,ip);
            stmt.setObject(5,value);
            stmt.setObject(6,1);
            insertRow = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn,stmt,null);
        }catch (Exception e){
            e.printStackTrace();
        }
       return insertRow > 0;
    }

    @Override
    public boolean update(Log model) {
        int updateRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            int id = model.getId();
            String level = model.getLevel();
            String user = model.getUsername();
            String ip = model.getIp();
            String sql ="UPDATE logs SET level=?, ip=?, user = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1,level);
            stmt.setObject(2,user);
            stmt.setObject(3,ip);
            stmt.setObject(4,id);
            updateRows = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn,stmt,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateRows > 0;
    }

    @Override
    public boolean delete(Log model) {
        int deleteRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            int id = model.getId();
            String sql = "UPDATE logs SET isDelete = ? WHERE id= ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1,0);
            stmt.setObject(2,id);
            deleteRows = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn, stmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteRows > 0;
    }
}
