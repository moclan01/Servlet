package com.example.dattuor.controller;

import com.example.dattuor.model.Tour;
import com.example.dattuor.service.TourService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tour-details")
public class TourDetailsController extends HttpServlet {
    private TourService tourService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        tourService = new TourService();

        long tourID = Long.parseLong(req.getParameter("tour-id"));

        Tour tour = tourService.getTour(tourID);

        req.setAttribute("tour", tour);
        req.getRequestDispatcher("tourDetails.jsp").forward(req, resp);
    }
}
