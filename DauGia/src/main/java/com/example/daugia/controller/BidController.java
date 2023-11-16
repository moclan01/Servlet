package com.example.daugia.controller;

import com.example.daugia.model.AuctionItem;
import com.example.daugia.model.User;
import com.example.daugia.service.AuctionDatabase;
import com.example.daugia.service.AuctionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/bid")
public class BidController extends HttpServlet{
    private AuctionDatabase auctionDatabase;
    private AuctionService auctionService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        auctionDatabase = AuctionDatabase.getInstance();
        auctionService = new AuctionService();

        User loginUser = (User)req.getSession().getAttribute("loginUser");
        long itemId = Long.parseLong(req.getParameter("item-id"));
        double bidPrice = Double.parseDouble(req.getParameter("bid-price"));

        if(loginUser == null){
            req.setAttribute("bidError", "Bạn chưa đăng nhập!");
            req.setCharacterEncoding("utf-8");
            req.getRequestDispatcher("ShowTopic.jsp").forward(req,resp);
        }else{
            AuctionItem auctionItem = auctionService.getAuctionItem(itemId);
            if (bidPrice < (auctionItem.getCurrentPrice() + auctionItem.getPriceStep())) {
                req.setCharacterEncoding("utf-8");
                req.setAttribute("bidError",
                        "Giá đấu phải lớn hơn " + (auctionItem.getCurrentPrice() + auctionItem.getPriceStep()));
                req.getRequestDispatcher("ShowTopic.jsp").include(req, resp);
            } else {
                auctionService.bid(loginUser, auctionItem, bidPrice);
                resp.sendRedirect("list-items");
            }
        }
    }
}
