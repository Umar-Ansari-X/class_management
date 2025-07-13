/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import jakarta.servlet.ServletException;

@WebServlet("/removeLectureHall")
public class RemoveLectureHallServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hallIdStr = request.getParameter("hallId");

        if (hallIdStr == null || hallIdStr.isEmpty()) {
            response.getWriter().write("failure");
            return;
        }

        try {
            int hallId = Integer.parseInt(hallIdStr);

            LectureHallDao lectureDao = new LectureHallDao();
            boolean success = lectureDao.deleteLectureHall(hallId); 

            response.getWriter().write(success ? "success" : "failure");
        } catch (NumberFormatException e) {
            response.getWriter().write("failure");
        }
    }
}

