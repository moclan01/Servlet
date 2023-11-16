package com.example.daugia.controller;

import com.example.daugia.model.AuctionItem;
import com.example.daugia.service.AuctionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show-topic")
public class ShowTopicController extends HttpServlet {
    private AuctionService auctionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        auctionService = new AuctionService();

        String topicId= req.getParameter("topic-id");
        AuctionItem auctionItem = auctionService.getAuctionItem(Long.parseLong(topicId));
        req.setAttribute("auctionItem", auctionItem);
        RequestDispatcher rd = req.getRequestDispatcher("ShowTopic.jsp");
//        req.getRequestDispatcher("ShowTopic.jsp").forward(req,resp);
        rd.forward(req,resp);
    }
}
