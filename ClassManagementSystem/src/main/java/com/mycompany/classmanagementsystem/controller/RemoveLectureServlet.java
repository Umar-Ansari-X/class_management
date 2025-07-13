/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeLecture")
public class RemoveLectureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hallIdStr = request.getParameter("hallId");
        String timeSlot = request.getParameter("timeSlot");

        if (hallIdStr == null || hallIdStr.isEmpty() || timeSlot == null || timeSlot.isEmpty()) {
            response.getWriter().write("failure");
            return;
        }

       
            int hallId = Integer.parseInt(hallIdStr);

            LectureDao lectureDao = new LectureDao();
            boolean success = lectureDao.removeLectureFromHall(hallId, timeSlot);

            response.getWriter().write(success ? "success" : "failure");

    }
}