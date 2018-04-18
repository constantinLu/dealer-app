package main.com.dealer.beans;


import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import com.dealer.services.inter.VehicleServiceInterface;
import main.com.dealer.util.SessionUtils;
import org.primefaces.model.UploadedFile;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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

    //upload a file with the selector
    private UploadedFile file;


    @EJB
    private VehicleServiceInterface vehicleService;


    //add a vehicle to DB
    public String registerVehicle() {
        int userId = Integer.valueOf(SessionUtils.getUserId());
        Vehicle vehicle = new Vehicle(model, brand, color, price, condition, userId);
        vehicleService.registerVehicle(vehicle);
        System.out.println("Vehicle added");
        return "home";
    }

    // TODO add method to call unmarshallVehicleData
    //add vehicles to db from generated objects
    public void addVehiclesFromGeneratedObj() {
       vehicleService.unmarshallVehicleData("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleData.xml");
        System.out.println("Vehicle imported");
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //FORWARD to vehicleRegistrationPage
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}


