package com.example.formnhapdulieu.controller;

import com.example.formnhapdulieu.model.User;
import com.example.formnhapdulieu.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService = new UserService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (username != null && password != null) {
            List<User> userList = userService.getAll();
            User newUser = new User(username, password, name, email);

            boolean userExist = false;
            for (User user : userList) {
                if (user.getUsername().equals(newUser.getUsername())) {
                    userExist = true;
                    break;
                }
            }

            if (!userExist) {
                boolean registerSuccess = userService.createUser(newUser);
                if (registerSuccess) {
                    resp.sendRedirect("/home");
                    return;
                } else {
                    req.setAttribute("errorMessage", "Register failed");
                }
            } else {
                req.setAttribute("errorMessage", "Username already exists");
            }
        } else {
            req.setAttribute("errorMessage", "Invalid data");
        }
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
