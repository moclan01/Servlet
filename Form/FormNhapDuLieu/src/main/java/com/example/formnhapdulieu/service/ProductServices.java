package com.example.formnhapdulieu.service;

import com.example.formnhapdulieu.dao.ProductDAO;
import com.example.formnhapdulieu.model.Product;

import java.util.List;

public class ProductServices {
    ProductDAO dao ;
    public ProductServices(){
        dao = new ProductDAO();
    }
    public List<Product> getAll(){
        return dao.getAll();
    }

    public boolean addProduct(Product product){
        return dao.insert(product);
    }

    public boolean updateProduct(Product product){
        return dao.update(product);
    }

    public  boolean deleteProduct(Product product){
        return dao.delete(product);
    }
}
