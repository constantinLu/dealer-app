package com.dealer.repository.inter;

import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface VehicleRepositoryInterface {

    VehicleEntity registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId);
}
