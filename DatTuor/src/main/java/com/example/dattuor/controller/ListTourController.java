package com.example.dattuor.controller;

import com.example.dattuor.service.TourService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/list-tour")
public class ListTourController extends HttpServlet {
    private TourService tourService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        tourService = new TourService();

        req.setAttribute("tours", tourService.getAllTours());
        req.getRequestDispatcher("listTours.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        tourService = null;
    }
}
