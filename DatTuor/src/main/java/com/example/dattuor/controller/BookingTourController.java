package com.example.dattuor.controller;

import com.example.dattuor.model.Booking;
import com.example.dattuor.model.Customer;
import com.example.dattuor.model.Tour;
import com.example.dattuor.service.TourService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/book-tour")
public class BookingTourController extends HttpServlet {
    private TourService tourService;

     private boolean checkInputRequired(HttpServletRequest req, HttpServletResponse resp,  String page, String ...inputs) throws ServletException, IOException {
        for (String input : inputs) {
            if (req.getParameter(input) == null || req.getParameter(input).equals("")) {
                req.setAttribute("error", "Vui lòng điền vào các mục bắt buộc (có dấu *)");
                req.getRequestDispatcher(page).forward(req, resp);
                return false;
            }
        }
        return true;
    }

    @Override
    public void init() throws ServletException {
        tourService = new TourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub


        long tourID = Long.parseLong(req.getParameter("tour-id"));
        Tour tour = tourService.getTour(tourID);

        req.setAttribute("tour", tour);
        req.getRequestDispatcher("bookingTour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (checkInputRequired(req, resp, "bookingTour.jsp", "full-name", "email", "departure-date", "adults") == true) {


            String fullName = req.getParameter("full-name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Customer customer = new Customer(fullName, address, email, phone);

            // if month > 12 then year plus 1; Ex 12/14/2023 -> 12/2/2024
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date departureDate;
            int children = 0;
            int adults = 0;
            long tourID = Long.parseLong(req.getParameter("tour-id"));
            Tour bookedTour = tourService.getTour(tourID);

            try {
                departureDate = simpleDateFormat.parse(req.getParameter("departure-date"));
                System.out.println(departureDate);
                if (departureDate == null) {
                    req.setAttribute("error", "Ngày không hợp lệ!");
                    req.getRequestDispatcher("bookingTour.jsp").include(req, resp);
                    return;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            adults = Integer.parseInt(req.getParameter("adults"));
            if (req.getParameter("children") != null)
                children = Integer.parseInt(req.getParameter("children"));

            Booking booking = new Booking(customer, departureDate, adults, children, bookedTour);

            tourService.saveCustomer(customer);
            tourService.saveBooking(booking);

            req.setAttribute("booking", booking);
            req.getRequestDispatcher("confirm.jsp").forward(req, resp);

        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        tourService = null;
    }
}
