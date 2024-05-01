package com.example.formnhapdulieu.controller;

import com.example.formnhapdulieu.model.User;
import com.example.formnhapdulieu.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
//
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            List<User> userList = userService.getAll();
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("name", user.getName());
                    response.sendRedirect("/home");
                    return;
                }
            }
            request.setAttribute("fail", "Tài khoản hoặc mật khẩu không đúng");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
