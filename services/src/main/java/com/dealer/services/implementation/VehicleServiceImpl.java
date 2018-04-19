package com.dealer.services.implementation;


import com.dealer.commons.dto.Vehicle;
import com.dealer.commons.utils.ConvertGeneratedDtoToEntity;
import com.dealer.commons.utils.DtoToEntity;
import com.dealer.commons.utils.EntityToDto;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import com.dealer.services.inter.VehicleServiceInterface;
import resources.generated.VehicleData;
import resources.generated.VehicleGenerated;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Stateless
public class VehicleServiceImpl implements VehicleServiceInterface {

    @EJB
    private VehicleRepositoryInterface vehicleRepositoryInterface;

    public Vehicle registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId) {
        //primesti un vehicle dto ca param
        //conert to entity
        //trimit entitatea ca param
        //DtoToEntity.convertToEntity(vehicle);
        VehicleEntity vehicleEntity = vehicleRepositoryInterface.registerVehicle(model, brand, color, price, condition, userId);
        return EntityToDto.convert(vehicleEntity);
    }


    public Vehicle registerVehicle(Vehicle vehicleDto) {
        VehicleEntity vehicleEntity = DtoToEntity.convertToEntity(vehicleDto);
        vehicleEntity = vehicleRepositoryInterface.registerVehicle(vehicleEntity);
        return EntityToDto.convert(vehicleEntity);
    }


    public VehicleData unmarshallVehicleData(File file) {

        VehicleData vehicleData = null;
        try {
           //File file = new File(str);
            //File file = new File("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(VehicleData.class);
            javax.xml.bind.Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            vehicleData = (VehicleData) jaxUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            System.out.println("NOT WORKING !!!!!!!!!!!");
            e.printStackTrace();
        }
        importVehicleData(vehicleData);
        return vehicleData;

    }

//    private File convertUploadedFile(UploadedFile uploadedFile) {
//
//    }


    //get the list of generatedVehicles and convert it to a list of vehicleEntities
    public void importVehicleData(VehicleData vehicleData) {
        List<VehicleEntity> vehicleEntityList = new ArrayList<VehicleEntity>();
        List<VehicleGenerated> tempList = vehicleData.getVehicles();
        Iterator<VehicleGenerated> iterator = tempList.iterator();
        while (iterator.hasNext()) {
            vehicleEntityList.add(ConvertGeneratedDtoToEntity.convertGeneratedVehicleToVehicleEntity(iterator.next()));
        }
        vehicleRepositoryInterface.importVehicles(vehicleEntityList);

    }

    public List<Vehicle> geVehicleList() {
        //convert here !
        List<VehicleEntity> vehicleEntityList = vehicleRepositoryInterface.getVehicleList();
        List<Vehicle> vehicleDtoList = EntityToDto.convertListEntityToDto(vehicleEntityList);
        return vehicleDtoList;
    }

}
