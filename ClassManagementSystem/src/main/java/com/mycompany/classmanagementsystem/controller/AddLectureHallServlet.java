/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.LectureHallDao;
import com.mycompany.classmanagementsystem.model.LectureHall;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@MultipartConfig
@WebServlet("/add-lecture-hall")
public class AddLectureHallServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buildingName = request.getParameter("buildingName");
        String floorNumberStr = request.getParameter("floorNumber");
        String capacityStr = request.getParameter("capacity");

        if (buildingName == null || floorNumberStr == null || capacityStr == null) {

            return;
        }

        int floorNumber = Integer.parseInt(floorNumberStr);
        int capacity = Integer.parseInt(capacityStr);

        LectureHall hall = new LectureHall();
        hall.setName(buildingName);
        hall.setCapacity(capacity);
        hall.setFloor(floorNumber);

        LectureHallDao hallDao = new LectureHallDao();
        hallDao.addLectureHall(hall);

    }
}