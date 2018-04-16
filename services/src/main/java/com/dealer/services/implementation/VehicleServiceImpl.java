package com.dealer.services.implementation;


import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.commons.utils.DtoToEntity;
import com.dealer.commons.utils.EntityToDto;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;
import com.dealer.services.inter.VehicleServiceInterface;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class VehicleServiceImpl implements VehicleServiceInterface {

    @EJB
    private VehicleRepositoryInterface vehicleRepositoryInterface;

    public Vehicle registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId) {
        // primesti un vehicle dto ca param
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

}
