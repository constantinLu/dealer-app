package main.com.dealer.beans;

import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import com.dealer.services.inter.VehicleServiceInterface;
import main.com.dealer.util.SessionUtils;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;
import main.com.dealer.util.SessionUtils;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.util.*;

import static main.com.dealer.util.SessionUtils.convertUploadedFile;

@ManagedBean(name = "vehicleBean", eager = true)
@SessionScoped
public class VehicleBean {

    private String model;
    private String brand;
    private Color color;
    private double price;
    private Condition condition;
    private Date registrationDate;
    private int userId;
    private Vehicle vehicle;

    private List<Vehicle> vehicleList;
    private List<Vehicle> filteredList;


    //get the enums to the page
    private List<Color> colorList = new ArrayList<>(EnumSet.allOf(Color.class));
    private List<Condition> conditionList = new ArrayList<>(EnumSet.allOf(Condition.class));

    //upload a file with the selector
    public UploadedFile file;
    //path for unmarshalling
    String inputString;


    @EJB
    private VehicleServiceInterface vehicleService;

    public String registerVehicle() {
        int userId = Integer.valueOf(SessionUtils.getUserId());
        Vehicle vehicle = new Vehicle(model, brand, color, price, condition, userId);
        vehicleService.registerVehicle(vehicle);
        System.out.println("Vehicle added");
        return "home";
    }

    public String showVehicles() {
        vehicleList = new ArrayList<>();
        vehicleList = vehicleService.geVehicleList();
        for (Vehicle v : vehicleList) {
            System.out.println(v + "\n");
        }
        return "carList";

    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            inputString = convertUploadedFile(file);
            vehicleService.unmarshallVehicleData(new File(inputString));
            System.out.println("ADDED");
        }
    }

    //UTIL METHOD
//    private boolean filterByPrice(Object value, Object filter, Locale locale) {
//        String filterText = (filter == null) ? null : filter.toString().trim();
//        if (filterText == null || filterText.equals("")) {
//            return true;
//        }
//        if (value == null) {
//            return false;
//        }
//        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
//    }


    //FORWARD to vehicleRegistrationPage
    public String addVehicle() {
        return "vehicleRegistration";
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<Vehicle> filteredList) {
        this.filteredList = filteredList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }


}


