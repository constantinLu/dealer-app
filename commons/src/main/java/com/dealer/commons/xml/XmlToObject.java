package com.dealer.commons.xml;

import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.VehicleEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlToObject {

    public static void main(String[] args) {

        try {
            File file = new File("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vehicle.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            Vehicle vehicleDTO = (Vehicle) jaxUnmarshaller.unmarshal(file);
            System.out.println(vehicleDTO.getUserId() + " " + vehicleDTO.getBrand() + " " + vehicleDTO.getColor());

        } catch (JAXBException e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
