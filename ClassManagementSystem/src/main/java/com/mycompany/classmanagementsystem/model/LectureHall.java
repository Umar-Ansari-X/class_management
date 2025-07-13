/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.model;

public class LectureHall {
    private int id;          
    private String name;     
    private int capacity;    
    private int floor;


    private Integer monday_9am_lecture_id;
    private Integer monday_11am_lecture_id;
    private Integer monday_1pm_lecture_id;
    private Integer monday_3pm_lecture_id;
    private Integer monday_5pm_lecture_id;
    
    private Integer tuesday_9am_lecture_id;
    private Integer tuesday_11am_lecture_id;
    private Integer tuesday_1pm_lecture_id;
    private Integer tuesday_3pm_lecture_id;
    private Integer tuesday_5pm_lecture_id;
    
    private Integer wednesday_9am_lecture_id;
    private Integer wednesday_11am_lecture_id;
    private Integer wednesday_1pm_lecture_id;
    private Integer wednesday_3pm_lecture_id;
    private Integer wednesday_5pm_lecture_id;
    
    private Integer thursday_9am_lecture_id;
    private Integer thursday_11am_lecture_id;
    private Integer thursday_1pm_lecture_id;
    private Integer thursday_3pm_lecture_id;
    private Integer thursday_5pm_lecture_id;    
    
    private Integer friday_9am_lecture_id;
    private Integer friday_11am_lecture_id;
    private Integer friday_1pm_lecture_id;
    private Integer friday_3pm_lecture_id;
    private Integer friday_5pm_lecture_id;    
    
    

    public Integer getMonday9amLectureId() { return monday_9am_lecture_id; }
    public void setMonday9amLectureId(Integer id) { this.monday_9am_lecture_id = id; }
    public Integer getMonday11amLectureId() { return monday_11am_lecture_id; }
    public void setMonday11amLectureId(Integer id) { this.monday_11am_lecture_id = id; }
    public Integer getMonday1pmLectureId() { return monday_1pm_lecture_id; }
    public void setMonday1pmLectureId(Integer id) { this.monday_1pm_lecture_id = id; }
    public Integer getMonday3pmLectureId() { return monday_3pm_lecture_id; }
    public void setMonday3pmLectureId(Integer id) { this.monday_3pm_lecture_id = id; }
    public Integer getMonday5pmLectureId() { return monday_5pm_lecture_id; }
    public void setMonday5pmLectureId(Integer id) { this.monday_5pm_lecture_id = id; }
                 
    public Integer getTuesday9amLectureId() { return tuesday_9am_lecture_id; }
    public void setTuesday9amLectureId(Integer id) { this.tuesday_9am_lecture_id = id; }
    public Integer getTuesday11amLectureId() { return tuesday_11am_lecture_id; }
    public void setTuesday11amLectureId(Integer id) { this.tuesday_11am_lecture_id = id; }
    public Integer getTuesday1pmLectureId() { return tuesday_1pm_lecture_id; }
    public void setTuesday1pmLectureId(Integer id) { this.tuesday_1pm_lecture_id = id; }
    public Integer getTuesday3pmLectureId() { return tuesday_3pm_lecture_id; }
    public void setTuesday3pmLectureId(Integer id) { this.tuesday_3pm_lecture_id = id; }
    public Integer getTuesday5pmLectureId() { return tuesday_5pm_lecture_id; }
    public void setTuesday5pmLectureId(Integer id) { this.tuesday_5pm_lecture_id = id; }
                 
    public Integer getWednesday9amLectureId() { return wednesday_9am_lecture_id; }
    public void setWednesday9amLectureId(Integer id) { this.wednesday_9am_lecture_id = id; }
    public Integer getWednesday11amLectureId() { return wednesday_11am_lecture_id; }
    public void setWednesday11amLectureId(Integer id) { this.wednesday_11am_lecture_id = id; }
    public Integer getWednesday1pmLectureId() { return wednesday_1pm_lecture_id; }
    public void setWednesday1pmLectureId(Integer id) { this.wednesday_1pm_lecture_id = id; }
    public Integer getWednesday3pmLectureId() { return wednesday_3pm_lecture_id; }
    public void setWednesday3pmLectureId(Integer id) { this.wednesday_3pm_lecture_id = id; }
    public Integer getWednesday5pmLectureId() { return wednesday_5pm_lecture_id; }
    public void setWednesday5pmLectureId(Integer id) { this.wednesday_5pm_lecture_id = id; }

    public Integer getThursday9amLectureId() { return thursday_9am_lecture_id; }
    public void setThursday9amLectureId(Integer id) { this.thursday_9am_lecture_id = id; }
    public Integer getThursday11amLectureId() { return thursday_11am_lecture_id; }
    public void setThursday11amLectureId(Integer id) { this.thursday_11am_lecture_id = id; }
    public Integer getThursday1pmLectureId() { return thursday_1pm_lecture_id; }
    public void setThursday1pmLectureId(Integer id) { this.thursday_1pm_lecture_id = id; }
    public Integer getThursday3pmLectureId() { return thursday_3pm_lecture_id; }
    public void setThursday3pmLectureId(Integer id) { this.thursday_3pm_lecture_id = id; }
    public Integer getThursday5pmLectureId() { return thursday_5pm_lecture_id; }
    public void setThursday5pmLectureId(Integer id) { this.thursday_5pm_lecture_id = id; }    
    
    public Integer getFriday9amLectureId() { return friday_9am_lecture_id; }
    public void setFriday9amLectureId(Integer id) { this.friday_9am_lecture_id = id; }
    public Integer getFriday11amLectureId() { return friday_11am_lecture_id; }
    public void setFriday11amLectureId(Integer id) { this.friday_11am_lecture_id = id; }
    public Integer getFriday1pmLectureId() { return friday_1pm_lecture_id; }
    public void setFriday1pmLectureId(Integer id) { this.friday_1pm_lecture_id = id; }
    public Integer getFriday3pmLectureId() { return friday_3pm_lecture_id; }
    public void setFriday3pmLectureId(Integer id) { this.friday_3pm_lecture_id = id; }
    public Integer getFriday5pmLectureId() { return friday_5pm_lecture_id; }
    public void setFriday5pmLectureId(Integer id) { this.friday_5pm_lecture_id = id; }    
    
    
    public LectureHall() {}  

    public LectureHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
