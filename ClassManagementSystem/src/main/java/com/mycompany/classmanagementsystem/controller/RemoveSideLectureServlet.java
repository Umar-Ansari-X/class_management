/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureDao;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/removeSideLecture")
public class RemoveSideLectureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String lectureIdStr = request.getParameter("lectureId");

        if (lectureIdStr == null || lectureIdStr.isEmpty()) {
            return;
        }

            int lectureId = Integer.parseInt(lectureIdStr);

            LectureDao lectureDao = new LectureDao();
            boolean success = lectureDao.removeLecture(lectureId);

            response.getWriter().write(success ? "success" : "failure");

    }
}
