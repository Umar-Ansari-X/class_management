/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.mycompany.classmanagementsystem.dao.LectureDao;
import com.mycompany.classmanagementsystem.model.Lecture;
import com.mycompany.classmanagementsystem.dao.UserDao;
import jakarta.servlet.ServletException;
import com.mycompany.classmanagementsystem.model.TimeSlotAssignment;
import java.util.List;
import java.util.Map;
import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import java.util.HashMap;
import com.mycompany.classmanagementsystem.model.LectureHall;
import com.mycompany.classmanagementsystem.model.ScheduleEntry;


@WebServlet("/user-dashboard")
public class UserDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  

        HttpSession session = request.getSession(false);

        if (session != null) {
            System.out.println("Session ID: " + session.getId());
            System.out.println("Session contents: " + session.getAttributeNames());
        }
        
        int userId = (int) request.getSession().getAttribute("id");


        try {
            UserDao userDao = new UserDao();
            
            
            List<TimeSlotAssignment> assignments = userDao.getStudentSchedule(userId);
            

            Map<String, ScheduleEntry> schedule = new HashMap<>();
            LectureHallDao hallDao = new LectureHallDao();
            LectureDao lectureDao = new LectureDao();
            
            for (TimeSlotAssignment assignment : assignments) {
                Integer lectureId = hallDao.getLectureForTimeSlot(
                    assignment.getHallId(), 
                    assignment.getTimeSlot()
                );
                
                if (lectureId != null) {
                    Lecture lecture = lectureDao.getLectureById(lectureId);
                    LectureHall hall = hallDao.getLectureHallById(assignment.getHallId());
                    
                    ScheduleEntry entry = new ScheduleEntry();

                            if (lecture != null) {
            entry.setLectureName(lecture.getName());
            entry.setProfessor(lecture.getProfessor());
        } else {
            entry.setLectureName("No Lecture Assigned");
            entry.setProfessor("N/A");
        }
                    
                    
                    entry.setBuildingName(hall.getName());
                    entry.setRoomNumber(hall.getFloor());
                    schedule.put(assignment.getTimeSlot(), entry);
                }
            }
            
            request.setAttribute("schedule", schedule);
            request.getRequestDispatcher("/WEB-INF/views/user/dashboard.jsp").forward(request, response);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}