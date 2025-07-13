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
import java.sql.SQLException;
import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import org.json.JSONObject;


@WebServlet("/removeStudent")
public class RemoveStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int hallId = Integer.parseInt(request.getParameter("hallId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String timeSlot = request.getParameter("timeSlot");   
        LectureHallDao dao = new LectureHallDao();
        JSONObject json = new JSONObject();
        
        try {
            dao.removeStudent(hallId, studentId, timeSlot);
            int newCount = dao.getAssignedStudentCount(hallId, timeSlot);
            json.put("success", true);
            json.put("newCount", newCount);
        } catch (SQLException e) {
            json.put("success", false);
        }
        
        response.getWriter().write(json.toString());
    }
}