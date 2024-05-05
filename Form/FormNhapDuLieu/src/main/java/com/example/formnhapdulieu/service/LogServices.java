package com.example.formnhapdulieu.service;

import com.example.formnhapdulieu.dao.LogDAO;
import com.example.formnhapdulieu.model.Log;

import java.util.List;

public class LogServices {
    LogDAO dao;
    public LogServices(){
        dao = new LogDAO();
    }
    public List<Log> getAll(){
        return dao.getAll();
    }

    public boolean addLog(Log log){
        return dao.insert(log);
    }

    public boolean updateLog(Log log){
        return dao.update(log);
    }

    public  boolean deleteLog(Log log){
        return dao.delete(log);
    }
}
