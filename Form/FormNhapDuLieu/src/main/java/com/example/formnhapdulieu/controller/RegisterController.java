package com.example.formnhapdulieu.controller;

import com.example.formnhapdulieu.model.Log;
import com.example.formnhapdulieu.model.User;
import com.example.formnhapdulieu.service.LogServices;
import com.example.formnhapdulieu.service.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    UserServices userService;
    LogServices logServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService = new UserServices();
        logServices = new LogServices();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (username != null && password != null) {
            List<User> userList = userService.getAll();

            User newUser = new User(username, password, name, email);
            if(userList == null){
                userService.createUser(newUser);
            }else {
                boolean userExist = false;
                for (User user : userList) {
                    if (user.getUsername().equals(newUser.getUsername())) {
                        userExist = true;
                        break;
                    }
                }

                if (!userExist) {
                    Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{8,}$");
                    Matcher matcher = pattern.matcher(password);
                    if(matcher.matches()){
                        boolean registerSuccess = userService.createUser(newUser);
                        String ip = req.getRemoteAddr();
                        Log log = new Log(Log.REGISTER_SERVICE,Log.LOG_LVL_ALERT,username,ip,User.TABLENAME);
                        logServices.addLog(log);
                        if (registerSuccess) {
                            resp.sendRedirect("/home");
                            return;
                        } else {
                            req.setAttribute("errorMessage", "Register failed");
                        }
                    }else {
                        req.setAttribute("errorPassword","mật khẩu phải bao gồm ít nhất 1 kí tự thường, 1 kí tự in hoa, 1 chữ số và 1 kí tự đặc biệt");
                    }
                } else {
                    req.setAttribute("errorMessage", "Username already exists");
                }
            }
        } else {
            req.setAttribute("errorMessage", "Invalid data");
        }
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }
}
