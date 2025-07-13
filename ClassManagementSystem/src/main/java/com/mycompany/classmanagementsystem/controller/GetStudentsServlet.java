/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;


import com.mycompany.classmanagementsystem.dao.UserDao;
import com.mycompany.classmanagementsystem.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import jakarta.servlet.annotation.MultipartConfig;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.sql.SQLException;

@MultipartConfig
@WebServlet("/getStudents")
public class GetStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int hallId = Integer.parseInt(request.getParameter("hallId"));
        String timeSlot = request.getParameter("timeSlot"); 
        
        UserDao userDao = new UserDao();
        LectureHallDao hallDao = new LectureHallDao();
        
        List<User> allStudents = userDao.getAllStudents();
        List<User> assignedStudents;
        List<User> otherassignedStudents;
        
        
        try {
            assignedStudents = hallDao.getAssignedStudents(hallId, timeSlot); 
        } catch (SQLException e) {
            return;
        }
        
        try {
            otherassignedStudents = hallDao.getOtherAssignedStudents(hallId, timeSlot); 
        } catch (SQLException e) {
            return;
        }
         
        
         
        List<User> availableStudents = new ArrayList<>(allStudents);
        
        availableStudents.removeIf(s -> assignedStudents.stream()
                .anyMatch(a -> a.getUsername().equals(s.getUsername())));
        
        availableStudents.removeIf(s -> 
            otherassignedStudents.stream().anyMatch(o -> o.getUsername().equals(s.getUsername())) &&
            assignedStudents.stream().noneMatch(a -> a.getUsername().equals(s.getUsername()))
        );
        
        JSONObject json = new JSONObject();
        json.put("available", convertStudentsToJson(availableStudents));
        json.put("assigned", convertStudentsToJson(assignedStudents));
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
    
    private List<JSONObject> convertStudentsToJson(List<User> students) {
        return students.stream().map(s -> {
            JSONObject obj = new JSONObject();
            obj.put("id", s.getId());
            obj.put("name", s.getName());
            obj.put("username", s.getUsername());
            return obj;
        }).collect(Collectors.toList());
    }
}