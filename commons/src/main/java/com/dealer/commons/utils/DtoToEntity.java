package com.dealer.commons.utils;

import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;


public class DtoToEntity {

    public static UserEntity convertToEntity(User user) {
        return new UserEntity(user.getUsername(), user.getPassword());
    }


    public static VehicleEntity convertToEntity(Vehicle vehicle) {
        return new VehicleEntity(vehicle.getModel(), vehicle.getBrand(),
                vehicle.getColor(), vehicle.getPrice(), vehicle.getCondition(), vehicle.getUserId());

    }

}


