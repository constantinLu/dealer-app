package main.com.dealer.beans;


import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name ="vehicleBean", eager = true)
@RequestScoped
public class VehicleBean {


    private String model;
    private String brand;
    private Color color;
    private double price;
    private Condition condition;
    private Date registrationDate;
    private int userId;



    public void vaildateVehicle() {
        System.out.println("Still working on it");
        System.out.println("Vehicle ADDDED");
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
