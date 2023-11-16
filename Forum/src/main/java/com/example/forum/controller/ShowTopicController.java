package com.example.forum.controller;

import com.example.forum.model.Topic;
import com.example.forum.service.ForumService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show-topic")
public class ShowTopicController extends HttpServlet {
    private ForumService forumService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forumService = ForumService.getInstance();

        int topicId = Integer.parseInt(req.getParameter("topic-id"));
        Topic topic = forumService.findTopic(topicId);

        req.setAttribute("topic", topic);
        req.getRequestDispatcher("ShowTopic.jsp").forward(req,resp);
    }
}
