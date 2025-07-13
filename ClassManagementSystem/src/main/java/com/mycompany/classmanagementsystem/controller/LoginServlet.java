/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.UserDao;
import com.mycompany.classmanagementsystem.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp")
                   .forward(request, response);
            return;
        }

        if (!user.getPassword().equals(password)) {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("/login.jsp")
                   .forward(request, response);
            return;
        }


        int userId = userDao.getUserIdByUsername(username);
        user.setId(userId);

        String currentDay = new SimpleDateFormat("EEEE").format(new Date());
        request.setAttribute("currentDay", currentDay);

        HttpSession session = request.getSession();
        session.setAttribute("id",       userId);
        session.setAttribute("user",     user);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role",     user.getRole());

        if ("admin".equals(user.getRole())) {
            request.getRequestDispatcher(
                "/WEB-INF/views/admin/dashboard.jsp")
                   .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/user-dashboard");
        }
    }
}