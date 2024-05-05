package com.example.formnhapdulieu.controller;

import com.example.formnhapdulieu.model.Log;
import com.example.formnhapdulieu.model.Product;
import com.example.formnhapdulieu.service.LogServices;
import com.example.formnhapdulieu.service.ProductServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {
    ProductServices productService;
    LogServices logServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductServices();
        logServices = new LogServices();

        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username");
        if (session == null || username == null) {
            req.setAttribute("noLogin", "Bạn chưa đăng nhập");
            resp.sendRedirect("/login");
            return;
        }

        String name = req.getParameter("name-product");
        String type = req.getParameter("type-product");
        int quantity;
        double price;
        try {
            quantity = Integer.parseInt(req.getParameter("quantity-product"));
            price = Double.parseDouble(req.getParameter("price-product"));
            Product product = new Product(name, type, quantity, price);
            productService.addProduct(product);
            String ip = req.getRemoteAddr();
            Log log = new Log(Log.INSERT,Log.LOG_LVL_ALERT,username,ip,Product.TABLENAME);
            logServices.addLog(log);
            req.setAttribute("success", "Thêm sản phẩm thành công");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        req.setAttribute("add-product", "");
        req.getRequestDispatcher("add-product.jsp").forward(req, resp);
    }
}
