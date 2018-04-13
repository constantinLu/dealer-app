package com.dealer.repository.entities;


import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="vehicle")
public class VehicleEntity {

    public VehicleEntity() {
    }

    public VehicleEntity(String model, String brand, Color color, double price, Condition condition, Date registrationDate, int userId) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.condition = condition;
        this.registrationDate = registrationDate;
        this.userId = userId;
    }



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int vid;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name="color")
    private Color color;

    @Column(name="price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name="condition")
    private Condition condition;

    @Temporal(TemporalType.DATE)
    @Column(name="registration_date")
    private Date registrationDate;

    @Column(name="user_id")
    private int userId;




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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
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
