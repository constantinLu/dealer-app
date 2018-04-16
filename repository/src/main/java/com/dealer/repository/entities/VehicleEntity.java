package com.dealer.repository.entities;


import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
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
    @Enumerated(EnumType.STRING)
    @Column(name="color")
    private Color color;

    @Column(name="price")
    private double price;

    // enum
    @Enumerated(EnumType.STRING)
    @Column(name="\"condition\"")
    private Condition condition;

    @Temporal(TemporalType.DATE)
    @Column(name="registration_date")
    private Date registrationDate;

    @Column(name ="user_id")
    private int userId;


    public VehicleEntity() {
    }

    public VehicleEntity(String model, String brand, Color color, double price, Condition condition, int userId) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.condition = condition;
        this.registrationDate = new Date();
        this.userId = userId;
    }

    @XmlAttribute
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @XmlElement
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @XmlElement
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
