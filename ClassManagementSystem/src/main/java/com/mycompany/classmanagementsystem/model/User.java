/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classmanagementsystem.model;
public class User {
    
    
    private String username;
    private String password;
    private String role;
    private String name; 
 private int id;
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User(String username, String password, String role, String name) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
    }
    
    public User() {}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
