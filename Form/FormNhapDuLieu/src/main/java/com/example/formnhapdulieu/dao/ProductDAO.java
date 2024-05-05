package com.example.formnhapdulieu.dao;

import com.example.formnhapdulieu.DB.JDBIConnector;
import com.example.formnhapdulieu.model.Product;
import com.example.formnhapdulieu.model.User;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements InterfaceDAO<Product> {

    public ProductDAO() {

    }


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String time = rs.getString("time");
                Product product = new Product(id, name, type, quantity, price, time);
                products.add(product);
            }
            JDBCUtils.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean insert(Product model) {
        int insertRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            String name = model.getName();
            String type = model.getType();
            int quantity = model.getQuantity();
            double price = model.getPrice();
            String sql = "INSERT INTO products(name, type, quantity, price, isDelete) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, name);
            stmt.setObject(2, type);
            stmt.setObject(3, quantity);
            stmt.setObject(4, price);
            stmt.setObject(5, 1);

            insertRows = stmt.executeUpdate();

            JDBCUtils.closeConnection(conn, stmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertRows > 0;
    }

    @Override
    public boolean update(Product model) {
        int updateRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            int id = model.getId();
            String name = model.getName();
            String type = model.getType();
            int quantity = model.getQuantity();
            double price = model.getQuantity();
            String sql = "UPDATE products SET name = ? ,type = ? ,quantity= ? ,price = ? WHERE id= ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, name);
            stmt.setObject(2, type);
            stmt.setObject(3, quantity);
            stmt.setObject(4, price);
            stmt.setObject(5, id);
            updateRows = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn, stmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateRows > 0;
    }

    @Override
    public boolean delete(Product model) {
        int deleteRows = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            int id = model.getId();
            String sql = "UPDATE products SET isDelete = ? WHERE id= ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setObject(1, 0);
            stmt.setObject(2, id);
            deleteRows = stmt.executeUpdate();
            JDBCUtils.closeConnection(conn, stmt, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteRows > 0;
    }
}

