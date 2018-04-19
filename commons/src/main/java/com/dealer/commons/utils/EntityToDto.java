package com.dealer.commons.utils;

import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    //converting a list of entities to DTO
    public static List<Vehicle> convertListEntityToDto(List<VehicleEntity> vehicleEntityList) {
        List<Vehicle> vehicleDtoList = new ArrayList<Vehicle>();
        Iterator<VehicleEntity> iterator = vehicleEntityList.iterator();
        while(iterator.hasNext()) {
            vehicleDtoList.add(convert(iterator.next()));
        }
        return vehicleDtoList;
    }


}
