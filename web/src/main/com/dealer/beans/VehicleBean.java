package main.com.dealer.beans;


import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import com.dealer.services.inter.VehicleServiceInterface;
import main.com.dealer.util.SessionUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.util.*;

@ManagedBean(name = "vehicleBean", eager = true)
@RequestScoped
public class VehicleBean {


    private String model;
    private String brand;
    private Color color;
    private double price;
    private Condition condition;
    private Date registrationDate;
    private int userId;
    private Vehicle vehicle;

    //get the enums to the page
    private List<Color> colorList = new ArrayList<>(EnumSet.allOf(Color.class));
    private List<Condition> conditionList = new ArrayList<>(EnumSet.allOf(Condition.class));


    @EJB
    private VehicleServiceInterface vehicleService;


    public String registerVehicle() {
        int userId = Integer.valueOf(SessionUtils.getUserId());
        Vehicle vehicle = new Vehicle(model, brand, color, price, condition, userId);
        vehicleService.registerVehicle(vehicle);
        System.out.println("Vehicle added");
        return "home";
    }

    public String addVehicle() {
        return "vehicleRegistration";
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

}


