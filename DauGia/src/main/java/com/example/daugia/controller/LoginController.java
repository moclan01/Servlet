package com.example.daugia.controller;

import com.example.daugia.model.User;
import com.example.daugia.service.AuctionDatabase;
import com.example.daugia.service.AuctionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AuctionDatabase auctionDatabase;
    private AuctionService auctionService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        auctionService = new AuctionService();

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User loginUser = auctionService.authenticateUser(username,password);
        if(loginUser != null){
            req.getSession().setAttribute("loginUser",loginUser);
            resp.sendRedirect("list-items");
        }else {
            req.setAttribute("errorLogin","Tên đăng nhập hoặc mật khẩu không hợp lệ!");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        auctionDatabase = null;
        auctionService = null;
    }
}
