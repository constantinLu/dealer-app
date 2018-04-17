package com.dealer.commons.xml;

import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

public class ObjectToXml {

    public static void main(String[] args) throws Exception {

        JAXBContext contextObj = JAXBContext.newInstance(Vehicle.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Vehicle vehicle = new Vehicle("Leon", "Seat", Color.ORANGE,
                299.99, Condition.USED, 1);
        Vehicle vehicle2 = new Vehicle("Golf", "vw", Color.ORANGE,
                399.99, Condition.USED, 1);
        marshallerObj.marshal(vehicle, new FileOutputStream("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleExample.xml"));
        marshallerObj.marshal(vehicle2, new FileOutputStream("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleExample.xml"));

    }
}


