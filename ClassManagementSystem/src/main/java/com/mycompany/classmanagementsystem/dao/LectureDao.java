/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.dao;

import com.mycompany.classmanagementsystem.model.Lecture;
import com.mycompany.classmanagementsystem.model.LectureHall;
import com.mycompany.classmanagementsystem.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectureDao {
    private final LectureHallDao lectureHallDao = new LectureHallDao();


public boolean assignLectureToHall(int hallId, int lectureId, String timeSlot) {
    String column = timeSlot.toLowerCase() + "_lecture_id"; 
    String sql = "UPDATE lecturehall SET " + column + " = ? WHERE id = ?";

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, lectureId);
        stmt.setInt(2, hallId);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        return false;
    }
}
    
public boolean removeLectureFromHall(int hallId, String timeSlot) {
    String column = timeSlot.toLowerCase() + "_lecture_id";
    String sql = "UPDATE lecturehall SET " + column + " = NULL WHERE id = ?";

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, hallId);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        return false;
    }
}
    
    public boolean addLecture(Lecture lecture) {
        String sql = "INSERT INTO Lecture (hall_id, name, professor, credits) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                    if (lecture.getHall() != null) {
            stmt.setInt(1, lecture.getHall().getId());
        } else {
            stmt.setNull(1, Types.INTEGER);  
        }
            
            stmt.setString(2, lecture.getName());
            stmt.setString(3, lecture.getProfessor());
            stmt.setInt(4, lecture.getCredits());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
          return false;
        }
}

    public List<Lecture> getAllLectures() {
        List<Lecture> lectures = new ArrayList<>();
        String sql = "SELECT * FROM Lecture";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setId(rs.getInt("id"));
                lecture.setName(rs.getString("name"));
                lecture.setProfessor(rs.getString("professor"));

                int hallId = rs.getInt("hall_id");
                LectureHall hall = lectureHallDao.getLectureHallById(hallId);
                lecture.setHall(hall);

                

                lectures.add(lecture);
            }

        } catch (SQLException e) {
        }
        return lectures;
    }

public Lecture getLectureById(int lectureId) throws SQLException {
    String sql = "SELECT * FROM lecture WHERE id = ?";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, lectureId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Lecture lecture = new Lecture();
            lecture.setId(rs.getInt("id"));
            lecture.setName(rs.getString("name"));
            lecture.setProfessor(rs.getString("professor"));
            return lecture;
        }
        return null;
    }
}

public boolean removeLecture(int lectureId) {
    String deleteLectureSql = "DELETE FROM Lecture WHERE id = ?";
    
    String[] timeSlots = {
        "monday_9am_lecture_id", "monday_11am_lecture_id", "monday_1pm_lecture_id", 
        "monday_3pm_lecture_id", "monday_5pm_lecture_id",
        "tuesday_9am_lecture_id", "tuesday_11am_lecture_id", "tuesday_1pm_lecture_id",
        "tuesday_3pm_lecture_id", "tuesday_5pm_lecture_id",
        "wednesday_9am_lecture_id", "wednesday_11am_lecture_id", "wednesday_1pm_lecture_id",
        "wednesday_3pm_lecture_id", "wednesday_5pm_lecture_id",
        "thursday_9am_lecture_id", "thursday_11am_lecture_id", "thursday_1pm_lecture_id",
        "thursday_3pm_lecture_id", "thursday_5pm_lecture_id",
        "friday_9am_lecture_id", "friday_11am_lecture_id", "friday_1pm_lecture_id",
        "friday_3pm_lecture_id", "friday_5pm_lecture_id"
    };

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement deleteLectureStmt = conn.prepareStatement(deleteLectureSql)) {

        conn.setAutoCommit(false);

        for (String timeSlot : timeSlots) {
            String updateSql = "UPDATE LectureHall SET " + timeSlot + " = NULL WHERE " + timeSlot + " = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setInt(1, lectureId);
                updateStmt.executeUpdate();
            }
        }

        deleteLectureStmt.setInt(1, lectureId);
        int rowsDeleted = deleteLectureStmt.executeUpdate();

        conn.commit();
        return rowsDeleted > 0;

    } catch (SQLException e) {

        return false;
    }
}
}