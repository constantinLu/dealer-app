//package com.dealer.services.conversion;
//
//import com.dealer.commons.utils.ConvertGeneratedDtoToEntity;
//import com.dealer.repository.entities.VehicleEntity;
//import com.dealer.repository.inter.VehicleRepositoryInterface;
//import resources.generated.VehicleData;
//import resources.generated.VehicleGenerated;
//
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//
//
//public class Unmarshaller {
//
//
//    private VehicleRepositoryInterface vehicleRepositoryInterface;
//
//    public VehicleData unmarshallVehicleData() {
//        VehicleData vehicleGenerated = null;
//        try {
//            File file = new File("C:\\Users\\constantin.lungu\\IdeaProjects\\DealerApp\\commons\\src\\main\\java\\resources\\vehicleData.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(VehicleData.class);
//            javax.xml.bind.Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
//            vehicleGenerated = (VehicleData) jaxUnmarshaller.unmarshal(file);
//        } catch (JAXBException e) {
//            System.out.println("NOT WORKING !!!!!!!!!!!");
//            e.printStackTrace();
//        }
//        return vehicleGenerated;
//
//    }
//
//    //get the list of generatedVehicles and convert it to a list of vehicleEntities
//    private List<VehicleEntity> getVehicles(VehicleData vehicleData) {
//        List<VehicleEntity> vehicleEntityList = new ArrayList<VehicleEntity>();
//        List<VehicleGenerated> tempList = vehicleData.getVehicles();
//        //List<VehicleEntity> vehicleEntityList = (List<VehicleEntity>) (List) tempList;
//        Iterator<VehicleGenerated> iterator = tempList.iterator();
//        while (iterator.hasNext()) {
//            vehicleEntityList.add(ConvertGeneratedDtoToEntity.convertGeneratedVehicleToVehicleEntity(iterator.next()));
//        }
//        vehicleRepositoryInterface.importVehicles(vehicleEntityList);
//        return vehicleEntityList;
//    }
//
//
//}
