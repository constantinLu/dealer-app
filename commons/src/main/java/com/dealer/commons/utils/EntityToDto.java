package com.dealer.commons.utils;

import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;

public class EntityToDto {

    public static User convert(UserEntity userEntity){
        User user = new User(userEntity.getUsername(), userEntity.getPassword());
        user.setId(userEntity.getId());

        return user;
    }

    public static Vehicle convert(VehicleEntity vehicleEntity) {
        return new Vehicle(vehicleEntity.getModel(), vehicleEntity.getBrand(),
                vehicleEntity.getColor(), vehicleEntity.getPrice(), vehicleEntity.getCondition(), vehicleEntity.getUserId());
    }


}
