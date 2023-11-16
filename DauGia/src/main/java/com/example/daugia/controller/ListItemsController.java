package com.example.daugia.controller;

import com.example.daugia.service.AuctionDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/list-items")
public class ListItemsController extends HttpServlet {
    private AuctionDatabase auctionDatabase;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        auctionDatabase = AuctionDatabase.getInstance();

        req.setAttribute("items", auctionDatabase.getAllAuctionItems());
        req.getRequestDispatcher("ListItems.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        auctionDatabase = null;
    }
}
