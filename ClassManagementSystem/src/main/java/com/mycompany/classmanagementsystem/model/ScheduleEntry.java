/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.model;

public class ScheduleEntry {
    private String lectureName;
    private String professor;
    private String buildingName;
    private int roomNumber;

    public String getLectureName() { return lectureName; }
    public void setLectureName(String lectureName) { this.lectureName = lectureName; }
    public String getProfessor() { return professor; }
    public void setProfessor(String professor) { this.professor = professor; }
    public String getBuildingName() { return buildingName; }
    public void setBuildingName(String buildingName) { this.buildingName = buildingName; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
}
