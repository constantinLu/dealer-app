package com.dealer.repository.entities;


import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int vid;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    private String brand;

    // enum
    @Column(name="color")
    private Color color;

    @Column(name="price")
    private double price;

    // enum
    @Column(name="\"condition\"")
    private String condition;

    @Temporal(TemporalType.DATE)
    @Column(name="registration_date")
    private Date registrationDate;

    // mapezi rel pe entitati
    @Column(name="user_id")
    private int userId;


    public VehicleEntity() {
    }

    public VehicleEntity(String model, String brand, Color color, double price, String condition, int userId) {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
