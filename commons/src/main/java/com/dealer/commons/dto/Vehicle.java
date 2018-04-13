package com.dealer.commons.dto;

import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import java.util.Date;

public class Vehicle {


    private int vid;

    private String model;

    private String brand;

    private Color color;

    private double price;

    private String condition;


    private Date registrationDate;


    private int userId;


    public Vehicle() {
    }


    public Vehicle(String model, String brand, Color color, double price, String condition, int userId) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.condition = condition;
        this.registrationDate = new Date();
        this.userId = userId;
    }


    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
