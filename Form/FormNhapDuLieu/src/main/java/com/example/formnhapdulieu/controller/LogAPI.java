package com.example.formnhapdulieu.controller;

import com.example.formnhapdulieu.model.Log;
import com.example.formnhapdulieu.service.LogServices;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/logAPI")
public class LogAPI extends HttpServlet {
    LogServices logServices;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logServices = new LogServices();
        try {
            Gson gson = new Gson();
            String jsonResp = "";
            List<Log> logs = logServices.getAll();
            jsonResp += "[";
            for(Log log: logs){
                jsonResp += gson.toJson(log);
                if(logs.indexOf(log) != logs.size() - 1){
                    jsonResp += ", \n";
                }
            }
            jsonResp += "]";
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().write(jsonResp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
