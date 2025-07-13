package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.UserDao;
import com.mycompany.classmanagementsystem.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register") 
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String name = null; 
        String studentId = null; 

        if ("user".equals(role)) {
            name = request.getParameter("name");
            studentId = username; 
        }

        User user = null;

        if ("user".equals(role)) {
            user = new User(studentId, password, role);
            user.setName(name); 
        } 
        else if ("admin".equals(role)) {
            user = new User(username, password, role);
        }

        UserDao userDao = new UserDao();
        boolean isRegistered = userDao.registerUser(user);

        if (isRegistered) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}