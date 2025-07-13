/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.dao;
import com.mycompany.classmanagementsystem.model.TimeSlotAssignment;
import com.mycompany.classmanagementsystem.model.User;
import com.mycompany.classmanagementsystem.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (username, password, role, name) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());

            if ("user".equals(user.getRole())) {
                stmt.setString(4, user.getName());
            } else {
                stmt.setNull(4, java.sql.Types.VARCHAR); 
            }

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        User user = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    if ("user".equals(rs.getString("role"))) {
                        user = new User(
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("role"),
                                rs.getString("name") 
                        );
                    } else {
                        user = new User(
                                
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("role")
                        );
                    }
                }
            }

        } catch (SQLException e) {
        }

        return user;
    }
public int getUserIdByUsername(String username) {
    String sql = "SELECT user_id FROM users WHERE username = ?";
    int id = 0; 

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                id = rs.getInt("user_id");
            }
        }

    } catch (SQLException e) {
    }

    return id;
}
public List<User> getAllStudents() {
    List<User> students = new ArrayList<>();
    String sql = "SELECT * FROM users WHERE role = 'user'"; 
    
    try (Connection conn = DatabaseUtil.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            User student = new User();
            student.setId(rs.getInt("user_id"));
            student.setUsername(rs.getString("username"));
            student.setName(rs.getString("name"));
            student.setRole(rs.getString("role"));
            students.add(student);
        }
    } catch (SQLException e) {
    }
    return students;
}
public List<TimeSlotAssignment> getStudentSchedule(int studentId) throws SQLException {
    List<TimeSlotAssignment> assignments = new ArrayList<>();
    String sql = "SELECT hall_id, time_slot FROM hall_students WHERE student_id = ?";
    
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            TimeSlotAssignment tsa = new TimeSlotAssignment();
            tsa.setHallId(rs.getInt("hall_id"));
            tsa.setTimeSlot(rs.getString("time_slot"));
            assignments.add(tsa);
        }
    }
    return assignments;
}
}