package com.example.forum.controller;

import com.example.forum.model.User;
import com.example.forum.service.ForumService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private ForumService forumService = ForumService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = forumService.checkUser(username,password);
        if(loginUser != null){
            HttpSession session =req.getSession();
            session.setAttribute("loginUser",loginUser);
            resp.sendRedirect("list-topic");
        }else{
            req.setAttribute("errorLogin", "Tên đăng nhập hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
