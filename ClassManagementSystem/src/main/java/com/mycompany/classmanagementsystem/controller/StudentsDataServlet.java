/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hi
 */
package com.mycompany.classmanagementsystem.controller;

import com.mycompany.classmanagementsystem.dao.UserDao;
import com.mycompany.classmanagementsystem.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/students-data") 
public class StudentsDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();
        List<User> students = userDao.getAllStudents();

        PrintWriter out = response.getWriter();
        out.print("[");

        for (int i = 0; i < students.size(); i++) {
            User student = students.get(i);
            out.print("{"
                    + "\"id\": " + student.getId() + ","
                    + "\"username\": \"" + student.getUsername() + "\","
                    + "\"name\": \"" + student.getName() + "\","
                    + "\"role\": \"" + student.getRole() + "\""
                    + (i < students.size() - 1 ? "}," : "}")
            );
        }

        out.print("]");
        out.flush();
    }
}