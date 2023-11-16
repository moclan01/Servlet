package com.example.dattuor.service;

import com.example.dattuor.model.Booking;
import com.example.dattuor.model.Customer;
import com.example.dattuor.model.Tour;

import java.util.Collection;

public class TourService {
    private TourDatabase database;

    public TourService() {
        database = TourDatabase.getInstance();
    }

    public Collection<Tour> getAllTours(){
        return database.getAllTours();
    }

    public Tour getTour(Long id){
        return database.getTourById(id);
    }

    public void saveCustomer(Customer customer){
        database.addCustomer(customer);
    }

    public void saveBooking(Booking booking){
        database.addBooking(booking);
    }
}
