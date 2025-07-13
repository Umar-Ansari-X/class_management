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
import com.mycompany.classmanagementsystem.model.LectureHall;
import org.json.JSONObject;

@WebServlet("/assignStudent")
public class AssignStudentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int hallId = Integer.parseInt(request.getParameter("hallId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String timeSlot = request.getParameter("timeSlot");
        System.out.println(134);
        
        LectureHallDao dao = new LectureHallDao();
        JSONObject json = new JSONObject();
        
        try {
            int currentCount = dao.getAssignedStudentCount(hallId, timeSlot);
            LectureHall hall = dao.getLectureHallById(hallId);
            
            if (currentCount >= hall.getCapacity()) {
                json.put("success", false);
                json.put("message", "Hall capacity reached!");
            } else {
                dao.assignStudent(hallId, studentId, timeSlot);
                json.put("success", true);
                json.put("newCount", currentCount + 1);
            }
        } catch (SQLException e) {
        }
        
        response.getWriter().write(json.toString());
    }
}
