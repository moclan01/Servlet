package com.example.forum.controller;

import com.example.forum.service.ForumService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/list-topic")
public class ListTopicController extends  HttpServlet{
    private ForumService forumService;

    @Override
    public void init() throws ServletException {
        forumService = ForumService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        forumService = ForumService.getInstance();
        req.setAttribute("topics", forumService.getTopics());
        req.getRequestDispatcher("ListTopic.jsp").forward(req,resp);
    }
}
