package com.dealer.commons.xml;

import resources.generatedObjects.VehicleData;
import resources.generatedObjects.VehicleGenerated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Unmarshal {

    public static VehicleData getCarList() {
        VehicleData vehicleGenerated = null;
        try {
            File file = new File("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(VehicleData.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            vehicleGenerated = (VehicleData) jaxUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            System.out.println("NOT WORKING !!!!!!!!!!!");
            e.printStackTrace();
        }
        return vehicleGenerated;

    }

    public static void main(String[] args) {
        System.out.println(getCarList());
    }

}
