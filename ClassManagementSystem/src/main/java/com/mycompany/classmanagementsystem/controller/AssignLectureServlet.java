/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;
import com.mycompany.classmanagementsystem.dao.*;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 *
 * @author Hi
 */



@MultipartConfig
@WebServlet("/assignLecture")
public class AssignLectureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        int hallId = Integer.parseInt(request.getParameter("hallId"));
        int lectureId = Integer.parseInt(request.getParameter("lectureId"));
        String timeSlot = request.getParameter("timeSlot"); 
        
        LectureDao lectureDao = new LectureDao();
        boolean success = lectureDao.assignLectureToHall(hallId, lectureId, timeSlot);
        
        if (success) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failure");
        }
    }
}