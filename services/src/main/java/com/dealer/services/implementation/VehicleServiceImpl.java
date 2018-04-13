package com.dealer.services.implementation;


import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.commons.utils.EntityToDto;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;
import com.dealer.services.inter.VehicleServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class VehicleServiceImpl implements VehicleServiceInterface {

    @EJB
    private VehicleRepositoryInterface vehicleRepositoryInterface;


    //converting to DTO
    public Vehicle registerVehicle(String model, String brand, Color color, double price, String condition, int userId) {
        // primesti un vehicle dto ca param
        //conert to entity
        //trimit entitatea ca param
        VehicleEntity vehicleEntity = vehicleRepositoryInterface.registerVehicle(model, brand, color, price, condition, userId);
        return EntityToDto.convert(vehicleEntity);
    }

}
