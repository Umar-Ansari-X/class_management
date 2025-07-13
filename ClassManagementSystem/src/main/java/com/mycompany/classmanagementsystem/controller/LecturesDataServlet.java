/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureDao;  
import com.mycompany.classmanagementsystem.model.Lecture;   
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/lectures-data")  
public class LecturesDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        LectureDao lectureDao = new LectureDao();
        List<Lecture> lectures = lectureDao.getAllLectures();  

        PrintWriter out = response.getWriter();
        out.print("[");

        for (int i = 0; i < lectures.size(); i++) {
            Lecture lecture = lectures.get(i);
            out.print("{"
                    + "\"id\": " + lecture.getId() + ","
                    + "\"name\": \"" + lecture.getName() + "\","
                    + "\"professor\": \"" + lecture.getProfessor() + "\","
                    + "\"credits\": " + lecture.getCredits()
                    + (i < lectures.size() - 1 ? "}," : "}")
            );
        }

        out.print("]");
        out.flush();
    }
}
