/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.dao;
import com.mycompany.classmanagementsystem.model.User;
import com.mycompany.classmanagementsystem.model.LectureHall;
import com.mycompany.classmanagementsystem.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class LectureHallDao {

    public boolean addLectureHall(LectureHall hall) {
        String sql = "INSERT INTO LectureHall (name, capacity, floor) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hall.getName());
            stmt.setInt(2, hall.getCapacity());
            stmt.setInt(3, hall.getFloor());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public List<LectureHall> getAllLectureHalls() {
        List<LectureHall> halls = new ArrayList<>();
        String sql = "SELECT * FROM LectureHall";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LectureHall hall = new LectureHall();
                hall.setId(rs.getInt("id"));
                hall.setName(rs.getString("name"));
                hall.setCapacity(rs.getInt("capacity"));
                hall.setFloor(rs.getInt("floor"));

                hall.setMonday9amLectureId(rs.getInt("monday_9am_lecture_id"));
                hall.setMonday11amLectureId(rs.getInt("monday_11am_lecture_id"));
                hall.setMonday1pmLectureId(rs.getInt("monday_1pm_lecture_id"));
                hall.setMonday3pmLectureId(rs.getInt("monday_3pm_lecture_id"));
                hall.setMonday5pmLectureId(rs.getInt("monday_5pm_lecture_id"));

                hall.setTuesday9amLectureId(rs.getInt("tuesday_9am_lecture_id"));
                hall.setTuesday11amLectureId(rs.getInt("tuesday_11am_lecture_id"));
                hall.setTuesday1pmLectureId(rs.getInt("tuesday_1pm_lecture_id"));
                hall.setTuesday3pmLectureId(rs.getInt("tuesday_3pm_lecture_id"));
                hall.setTuesday5pmLectureId(rs.getInt("tuesday_5pm_lecture_id"));

                hall.setWednesday9amLectureId(rs.getInt("wednesday_9am_lecture_id"));
                hall.setWednesday11amLectureId(rs.getInt("wednesday_11am_lecture_id"));
                hall.setWednesday1pmLectureId(rs.getInt("wednesday_1pm_lecture_id"));
                hall.setWednesday3pmLectureId(rs.getInt("wednesday_3pm_lecture_id"));
                hall.setWednesday5pmLectureId(rs.getInt("wednesday_5pm_lecture_id"));
         
                hall.setThursday9amLectureId(rs.getInt("thursday_9am_lecture_id"));
                hall.setThursday11amLectureId(rs.getInt("thursday_11am_lecture_id"));
                hall.setThursday1pmLectureId(rs.getInt("thursday_1pm_lecture_id"));
                hall.setThursday3pmLectureId(rs.getInt("thursday_3pm_lecture_id"));
                hall.setThursday5pmLectureId(rs.getInt("thursday_5pm_lecture_id"));

                hall.setFriday9amLectureId(rs.getInt("friday_9am_lecture_id"));
                hall.setFriday11amLectureId(rs.getInt("friday_11am_lecture_id"));
                hall.setFriday1pmLectureId(rs.getInt("friday_1pm_lecture_id"));
                hall.setFriday3pmLectureId(rs.getInt("friday_3pm_lecture_id"));
                hall.setFriday5pmLectureId(rs.getInt("friday_5pm_lecture_id"));                
                
                

                halls.add(hall);
            }

        } catch (SQLException e) {
        }
        return halls;
    }

    public LectureHall getLectureHallById(int id) {
        String sql = "SELECT * FROM LectureHall WHERE id = ?";
        LectureHall hall = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hall = new LectureHall();
                    hall.setId(rs.getInt("id"));
                    hall.setName(rs.getString("name"));
                    hall.setCapacity(rs.getInt("capacity"));
                    hall.setFloor(rs.getInt("floor"));


                hall.setMonday9amLectureId(rs.getInt("monday_9am_lecture_id"));
                hall.setMonday11amLectureId(rs.getInt("monday_11am_lecture_id"));
                hall.setMonday1pmLectureId(rs.getInt("monday_1pm_lecture_id"));
                hall.setMonday3pmLectureId(rs.getInt("monday_3pm_lecture_id"));
                hall.setMonday5pmLectureId(rs.getInt("monday_5pm_lecture_id"));

                hall.setTuesday9amLectureId(rs.getInt("tuesday_9am_lecture_id"));
                hall.setTuesday11amLectureId(rs.getInt("tuesday_11am_lecture_id"));
                hall.setTuesday1pmLectureId(rs.getInt("tuesday_1pm_lecture_id"));
                hall.setTuesday3pmLectureId(rs.getInt("tuesday_3pm_lecture_id"));
                hall.setTuesday5pmLectureId(rs.getInt("tuesday_5pm_lecture_id"));

                hall.setWednesday9amLectureId(rs.getInt("wednesday_9am_lecture_id"));
                hall.setWednesday11amLectureId(rs.getInt("wednesday_11am_lecture_id"));
                hall.setWednesday1pmLectureId(rs.getInt("wednesday_1pm_lecture_id"));
                hall.setWednesday3pmLectureId(rs.getInt("wednesday_3pm_lecture_id"));
                hall.setWednesday5pmLectureId(rs.getInt("wednesday_5pm_lecture_id"));
         
                hall.setThursday9amLectureId(rs.getInt("thursday_9am_lecture_id"));
                hall.setThursday11amLectureId(rs.getInt("thursday_11am_lecture_id"));
                hall.setThursday1pmLectureId(rs.getInt("thursday_1pm_lecture_id"));
                hall.setThursday3pmLectureId(rs.getInt("thursday_3pm_lecture_id"));
                hall.setThursday5pmLectureId(rs.getInt("thursday_5pm_lecture_id"));

                hall.setFriday9amLectureId(rs.getInt("friday_9am_lecture_id"));
                hall.setFriday11amLectureId(rs.getInt("friday_11am_lecture_id"));
                hall.setFriday1pmLectureId(rs.getInt("friday_1pm_lecture_id"));
                hall.setFriday3pmLectureId(rs.getInt("friday_3pm_lecture_id"));
                hall.setFriday5pmLectureId(rs.getInt("friday_5pm_lecture_id"));    

                }
            }

        } catch (SQLException e) {
        }
        return hall;
    }

    public boolean updateLectureHall(LectureHall hall) {
        String sql = "UPDATE LectureHall SET name = ?, capacity = ?, floor = ?, " +
                     "monday_9am_lecture_id = ?, monday_11am_lecture_id = ?, monday_1pm_lecture_id = ?, " +
                     "monday_3pm_lecture_id = ?, monday_5pm_lecture_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hall.getName());
            stmt.setInt(2, hall.getCapacity());
            stmt.setInt(3, hall.getFloor());

            stmt.setInt(4, hall.getMonday9amLectureId());
            stmt.setInt(5, hall.getMonday11amLectureId());
            stmt.setInt(6, hall.getMonday1pmLectureId());
            stmt.setInt(7, hall.getMonday3pmLectureId());
            stmt.setInt(8, hall.getMonday5pmLectureId());
            
            stmt.setInt(4, hall.getTuesday9amLectureId());
            stmt.setInt(5, hall.getTuesday11amLectureId());
            stmt.setInt(6, hall.getTuesday1pmLectureId());
            stmt.setInt(7, hall.getTuesday3pmLectureId());
            stmt.setInt(8, hall.getTuesday5pmLectureId());            
            
            stmt.setInt(4, hall.getWednesday9amLectureId());
            stmt.setInt(5, hall.getWednesday11amLectureId());
            stmt.setInt(6, hall.getWednesday1pmLectureId());
            stmt.setInt(7, hall.getWednesday3pmLectureId());
            stmt.setInt(8, hall.getWednesday5pmLectureId());            
            
            stmt.setInt(4, hall.getThursday9amLectureId());
            stmt.setInt(5, hall.getThursday11amLectureId());
            stmt.setInt(6, hall.getThursday1pmLectureId());
            stmt.setInt(7, hall.getThursday3pmLectureId());
            stmt.setInt(8, hall.getThursday5pmLectureId());            
            
            
            stmt.setInt(4, hall.getFriday9amLectureId());
            stmt.setInt(5, hall.getFriday11amLectureId());
            stmt.setInt(6, hall.getFriday1pmLectureId());
            stmt.setInt(7, hall.getFriday3pmLectureId());
            stmt.setInt(8, hall.getFriday5pmLectureId());            
            
            
            stmt.setInt(9, hall.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteLectureHall(int id) {
        String deleteHallSql = "DELETE FROM LectureHall WHERE id = ?";
        String deleteHallStudentsSql = "DELETE FROM hall_students WHERE hall_id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement deleteHallStmt = conn.prepareStatement(deleteHallSql);
             PreparedStatement deleteHallStudentsStmt = conn.prepareStatement(deleteHallStudentsSql)) {

            conn.setAutoCommit(false);

            deleteHallStudentsStmt.setInt(1, id);
            deleteHallStudentsStmt.executeUpdate();

            deleteHallStmt.setInt(1, id);
            int rowsDeleted = deleteHallStmt.executeUpdate();

            conn.commit();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean assignLectureToHall(int hallId, int lectureId, String timeSlot) {
        String column = timeSlot.toLowerCase() + "_lecture_id";
        String sql = "UPDATE LectureHall SET " + column + " = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, lectureId);
            stmt.setInt(2, hallId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean removeLectureFromHall(int hallId, String timeSlot) {
        String column = timeSlot.toLowerCase() + "_lecture_id";
        String sql = "UPDATE LectureHall SET " + column + " = NULL WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, hallId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            return false;
        }
    }

public List<User> getAssignedStudents(int hallId, String timeSlot) throws SQLException {
    List<User> students = new ArrayList<>();
    String sql = "SELECT u.* FROM users u " +
                 "JOIN hall_students hs ON u.user_id = hs.student_id " +
                 "WHERE hs.hall_id = ? AND hs.time_slot = ?";

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, hallId);
        stmt.setString(2, timeSlot);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            students.add(user);
        }
    }
    return students;
}

public List<User> getOtherAssignedStudents(int hallId, String timeSlot) throws SQLException {
    List<User> students = new ArrayList<>();
    String sql = "SELECT u.* FROM users u " +
                 "JOIN hall_students hs ON u.user_id = hs.student_id " +
                 "WHERE hs.hall_id != ? AND hs.time_slot = ?";

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, hallId);
        stmt.setString(2, timeSlot);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            students.add(user);
        }
    }
    return students;
}




    public int getAssignedStudentCount(int hallId, String timeSlot) throws SQLException {
        String sql = "SELECT COUNT(*) FROM hall_students WHERE hall_id = ? AND time_slot = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hallId);
            stmt.setString(2, timeSlot.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    public void assignStudent(int hallId, int studentId, String timeSlot) throws SQLException {
        String sql = "INSERT INTO hall_students (hall_id, student_id, time_slot) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hallId);
            stmt.setInt(2, studentId);
            stmt.setString(3, timeSlot.toLowerCase());
            stmt.executeUpdate();
        }
    }

    public void removeStudent(int hallId, int studentId, String timeSlot) throws SQLException {
        String sql = "DELETE FROM hall_students WHERE hall_id = ? AND student_id = ? AND time_slot = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hallId);
            stmt.setInt(2, studentId);
            stmt.setString(3, timeSlot.toLowerCase());
            stmt.executeUpdate();
        }
    }
    
    public Integer getLectureForTimeSlot(int hallId, String timeSlot) throws SQLException {
    String column = timeSlot.toLowerCase() + "_lecture_id";
    String sql = "SELECT " + column + " FROM lecturehall WHERE id = ?";
    
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, hallId);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getInt(1) : null;
    }
}
    
}