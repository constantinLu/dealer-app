package com.dealer.repository.inter;

import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface VehicleRepositoryInterface {

    //not valid
    VehicleEntity registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId);

    VehicleEntity registerVehicle(VehicleEntity vehicleEntity);

    void importVehicles(List<VehicleEntity> vehicleEntityList);








}
