package com.example.formnhapdulieu.service;

import com.example.formnhapdulieu.dao.UserDAO;
import com.example.formnhapdulieu.model.User;

import java.util.List;

public class UserServices {
    UserDAO dao;

    public UserServices(){
        dao = new UserDAO();
    }
    public List<User> getAll(){
        return dao.getAll();
    }

    public boolean createUser(User user){
        return dao.insert(user);
    }

    public boolean updateUser(User user){
        return dao.update(user);
    }

    public  boolean deleteUser(User user){
        return dao.delete(user);
    }
}
