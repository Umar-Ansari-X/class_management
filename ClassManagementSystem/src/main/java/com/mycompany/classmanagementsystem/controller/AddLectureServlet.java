/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureDao;

import com.mycompany.classmanagementsystem.model.Lecture;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig
@WebServlet("/add-lecture")
public class AddLectureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        System.out.println(11);
        System.out.println(request.getParameter("subject"));
        String subject = request.getParameter("subject");
        String professor = request.getParameter("professor");
        int credits = Integer.parseInt(request.getParameter("credits"));

        Lecture lecture = new Lecture();
        lecture.setName(subject + " (" + credits + " credits)");
        lecture.setProfessor(professor);
        lecture.setCredits(credits);

        lecture.setHall(null);
  
        
        LectureDao lectureDao = new LectureDao();
        lectureDao.addLecture(lecture);


    }
}

