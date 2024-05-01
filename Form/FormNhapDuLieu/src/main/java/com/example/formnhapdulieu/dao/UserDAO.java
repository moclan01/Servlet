package com.example.formnhapdulieu.dao;

import com.example.formnhapdulieu.model.User;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Map;

public class UserDAO implements InterfaceDAO<User>{
    private String table = "Users";
    private Jdbi jdbi;
    public UserDAO(){
        this.jdbi =  ConnectDB.getJdbi();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

    public void setJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<User> getAll() {
        List<User> users = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM Users")
                    .mapToBean(User.class)
                    .list()
        );
        return users;
    }

    @Override
    public boolean insert(User model) {
        String username = model.getUsername();
        String password = model.getPassword();
        String name = model.getName();
        String email = model.getEmail();

        int insertRows = jdbi.withHandle(handle ->
            handle.createUpdate("INSERT INTO Users (username, password, name, email) VALUES(?,?,?,?)")
                    .bind(0,username)
                    .bind(1,password)
                    .bind(2,name)
                    .bind(3,email)
                    .execute()
        );
        return insertRows > 0;
    }

    @Override
    public boolean update(User model) {
        String username = model.getUsername();
        String password = model.getPassword();
        String name = model.getName();
        String email = model.getEmail();

        int updateRows = jdbi.withHandle(handle ->
            handle.createUpdate("UPDATE Users SET name = ?, email = ? WHERE username = ?")
                    .bind(0,model.getName())
                    .bind(1,model.getEmail())
                    .bind(2,model.getUsername())
                    .execute()
        );
        return updateRows > 0;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }

}
