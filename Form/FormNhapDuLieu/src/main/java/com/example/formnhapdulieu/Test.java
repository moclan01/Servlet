package com.example.formnhapdulieu;

import com.example.formnhapdulieu.model.User;
import com.example.formnhapdulieu.service.UserService;

public class Test {
    public static void main(String[] args) {
    UserService userService = new UserService();
    for(User user : userService.getAll()){
        System.out.println(user);
    }
    }
}
