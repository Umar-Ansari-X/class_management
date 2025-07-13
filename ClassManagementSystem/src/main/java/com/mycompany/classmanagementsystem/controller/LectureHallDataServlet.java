/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import com.mycompany.classmanagementsystem.model.LectureHall;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/lecture-halls-data")
public class LectureHallDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        LectureHallDao hallDao = new LectureHallDao();
        List<LectureHall> halls = hallDao.getAllLectureHalls();

        PrintWriter out = response.getWriter();
        out.print("[");
        

        for (int i = 0; i < halls.size(); i++) {
            LectureHall hall = halls.get(i);
            
            
            try {
                out.print("{"
                        + "\"id\": " + hall.getId() + ","
                        + "\"name\": \"" + hall.getName() + "\","
                        + "\"floor\": \"" + hall.getFloor() + "\","
                        + "\"capacity\": " + hall.getCapacity() + ","

                        + "\"monday_9am_lecture_id\": " + (hall.getMonday9amLectureId() != null ? hall.getMonday9amLectureId() : "null") + ","
                        + "\"monday_11am_lecture_id\": " + (hall.getMonday11amLectureId() != null ? hall.getMonday11amLectureId() : "null") + ","
                        + "\"monday_1pm_lecture_id\": " + (hall.getMonday1pmLectureId() != null ? hall.getMonday1pmLectureId() : "null") + ","
                        + "\"monday_3pm_lecture_id\": " + (hall.getMonday3pmLectureId() != null ? hall.getMonday3pmLectureId() : "null") + ","
                        + "\"monday_5pm_lecture_id\": " + (hall.getMonday5pmLectureId() != null ? hall.getMonday5pmLectureId() : "null") + ","

                        + "\"monday_9am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "monday_9am") + ","
                        + "\"monday_11am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "monday_11am") + ","
                        + "\"monday_1pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "monday_1pm") + ","
                        + "\"monday_3pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "monday_3pm") + ","
                        + "\"monday_5pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "monday_5pm") + ","

                        + "\"tuesday_9am_lecture_id\": " + (hall.getTuesday9amLectureId() != null ? hall.getTuesday9amLectureId() : "null") + ","
                        + "\"tuesday_11am_lecture_id\": " + (hall.getTuesday11amLectureId() != null ? hall.getTuesday11amLectureId() : "null") + ","
                        + "\"tuesday_1pm_lecture_id\": " + (hall.getTuesday1pmLectureId() != null ? hall.getTuesday1pmLectureId() : "null") + ","
                        + "\"tuesday_3pm_lecture_id\": " + (hall.getTuesday3pmLectureId() != null ? hall.getTuesday3pmLectureId() : "null") + ","
                        + "\"tuesday_5pm_lecture_id\": " + (hall.getTuesday5pmLectureId() != null ? hall.getTuesday5pmLectureId() : "null") + ","

                        + "\"tuesday_9am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "tuesday_9am") + ","
                        + "\"tuesday_11am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "tuesday_11am") + ","
                        + "\"tuesday_1pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "tuesday_1pm") + ","
                        + "\"tuesday_3pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "tuesday_3pm") + ","
                        + "\"tuesday_5pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "tuesday_5pm") + ","

                        + "\"wednesday_9am_lecture_id\": " + (hall.getWednesday9amLectureId() != null ? hall.getWednesday9amLectureId() : "null") + ","
                        + "\"wednesday_11am_lecture_id\": " + (hall.getWednesday11amLectureId() != null ? hall.getWednesday11amLectureId() : "null") + ","
                        + "\"wednesday_1pm_lecture_id\": " + (hall.getWednesday1pmLectureId() != null ? hall.getWednesday1pmLectureId() : "null") + ","
                        + "\"wednesday_3pm_lecture_id\": " + (hall.getWednesday3pmLectureId() != null ? hall.getWednesday3pmLectureId() : "null") + ","
                        + "\"wednesday_5pm_lecture_id\": " + (hall.getWednesday5pmLectureId() != null ? hall.getWednesday5pmLectureId() : "null") + ","

                        + "\"wednesday_9am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "wednesday_9am") + ","
                        + "\"wednesday_11am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "wednesday_11am") + ","
                        + "\"wednesday_1pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "wednesday_1pm") + ","
                        + "\"wednesday_3pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "wednesday_3pm") + ","
                        + "\"wednesday_5pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "wednesday_5pm") + ","


                        + "\"thursday_9am_lecture_id\": " + (hall.getThursday9amLectureId() != null ? hall.getThursday9amLectureId() : "null") + ","
                        + "\"thursday_11am_lecture_id\": " + (hall.getThursday11amLectureId() != null ? hall.getThursday11amLectureId() : "null") + ","
                        + "\"thursday_1pm_lecture_id\": " + (hall.getThursday1pmLectureId() != null ? hall.getThursday1pmLectureId() : "null") + ","
                        + "\"thursday_3pm_lecture_id\": " + (hall.getThursday3pmLectureId() != null ? hall.getThursday3pmLectureId() : "null") + ","
                        + "\"thursday_5pm_lecture_id\": " + (hall.getThursday5pmLectureId() != null ? hall.getThursday5pmLectureId() : "null") + ","

                        + "\"thursday_9am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "thursday_9am") + ","
                        + "\"thursday_11am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "thursday_11am") + ","
                        + "\"thursday_1pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "thursday_1pm") + ","
                        + "\"thursday_3pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "thursday_3pm") + ","
                        + "\"thursday_5pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "thursday_5pm") + ","



                        + "\"friday_9am_lecture_id\": " + (hall.getFriday9amLectureId() != null ? hall.getFriday9amLectureId() : "null") + ","
                        + "\"friday_11am_lecture_id\": " + (hall.getFriday11amLectureId() != null ? hall.getFriday11amLectureId() : "null") + ","
                        + "\"friday_1pm_lecture_id\": " + (hall.getFriday1pmLectureId() != null ? hall.getFriday1pmLectureId() : "null") + ","
                        + "\"friday_3pm_lecture_id\": " + (hall.getFriday3pmLectureId() != null ? hall.getFriday3pmLectureId() : "null") + ","
                        + "\"friday_5pm_lecture_id\": " + (hall.getFriday5pmLectureId() != null ? hall.getFriday5pmLectureId() : "null") + ","

                        + "\"friday_9am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "friday_9am") + ","
                        + "\"friday_11am_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "friday_11am") + ","
                        + "\"friday_1pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "friday_1pm") + ","
                        + "\"friday_3pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "friday_3pm") + ","
                        + "\"friday_5pm_students\": " + hallDao.getAssignedStudentCount(hall.getId(), "friday_5pm") 
                        
                        
                        + (i < halls.size() - 1 ? "}," : "}")
                );

                          
                
                
                
                
                
                
                
                
                
                
            } catch (SQLException e) {
            }
        }
        

        out.print("]");
        out.flush();
    }
}