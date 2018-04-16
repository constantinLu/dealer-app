package main.com.dealer.beans;


import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.util.*;

@ManagedBean(name = "vehicleBean", eager = true)
@ApplicationScoped
public class VehicleBean {


    private String model;
    private String brand;
    private Color color;
    private double price;
    private Condition condition;
    private Date registrationDate;
    private int userId;
    private Vehicle vehicle;


    @EJB
    private VehicleRepositoryInterface vehicleRepositoryInterface;


    public  List<Color> colorList() {
        return new ArrayList<Color>(EnumSet.allOf(Color.class));
        }


    public String registerVehicle() {
        Vehicle vehicle = new Vehicle(model, brand, color, price, condition, userId);
        //creezi un dto vehicle
        //la apelul metodei trimiti dto ca param
        vehicleRepositoryInterface.registerVehicle(model, brand, color, price, condition, userId);
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

    public VehicleRepositoryInterface getVehicleRepositoryInterface() {
        return vehicleRepositoryInterface;
    }

    public void setVehicleRepositoryInterface(VehicleRepositoryInterface vehicleRepositoryInterface) {
        this.vehicleRepositoryInterface = vehicleRepositoryInterface;
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

    public static void main(String[] args) {
        VehicleBean v = new VehicleBean();

    }
}


