package com.example.formnhapdulieu.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    public List<T> getAll();
    public boolean insert(T model);
    public boolean update(T model);
    public boolean delete(T model);

}
