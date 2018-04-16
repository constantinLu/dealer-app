package com.dealer.commons.dto;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private Vehicle vehicle;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}