/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.*;
import com.mycompany.classmanagementsystem.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private final LectureHallDao lectureHallDao = new LectureHallDao(); 
    private final LectureDao lectureDao = new LectureDao(); 
    private final UserDao userDao = new UserDao(); 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        final String path = request.getPathInfo();
        final String fragment = (path == null || path.equals("/")) 
            ? "lecture-halls" 
            : path.substring(1);

        if (fragment.endsWith("-list")) {
            
            String section = fragment.replace("-list", "");
            switch (section) {
                case "lecture-halls" -> {
                    List<LectureHall> halls = lectureHallDao.getAllLectureHalls(); 
                    request.setAttribute("lectureHalls", halls != null ? halls : new ArrayList<>());
                    request.getRequestDispatcher("/WEB-INF/views/admin/lecture-halls-list.jsp")
                           .forward(request, response);
                }
                case "lectures" -> {
                    List<Lecture> lectures = lectureDao.getAllLectures(); 
                    request.setAttribute("lectures", lectures != null ? lectures : new ArrayList<>());
                    request.getRequestDispatcher("/WEB-INF/views/admin/lectures-list.jsp")
                           .forward(request, response);
                }
                case "students" -> {
                    List<User> students = userDao.getAllStudents(); // Call on instance
                    request.setAttribute("students", students != null ? students : new ArrayList<>());
                    request.getRequestDispatcher("/WEB-INF/views/admin/students-list.jsp")
                           .forward(request, response);
                }
                default -> throw new IllegalArgumentException("Invalid section: " + section);
            }
        }
    }
}