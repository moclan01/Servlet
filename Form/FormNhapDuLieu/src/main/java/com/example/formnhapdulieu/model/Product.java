package com.example.formnhapdulieu.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Product implements Serializable {

    public static final String TABLENAME = "Products";
    int id;
    String name;
    String type;
    int quantity;
    double price;
    String time;

    public Product(String name, String type, int quantity, double price) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int id, String name, String type, int quantity, double price, String time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
    }

    public Product() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
