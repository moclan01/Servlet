package com.example.formnhapdulieu;

import com.example.formnhapdulieu.model.User;
import com.example.formnhapdulieu.service.UserServices;

public class Test {
    public static void main(String[] args) {
    UserServices userService = new UserServices();
    for(User user : userService.getAll()){
        System.out.println(user);
    }
    }
}
