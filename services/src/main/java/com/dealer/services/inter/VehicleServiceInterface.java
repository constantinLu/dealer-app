package com.dealer.services.inter;

import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.ejb.Local;

@Local
public interface VehicleServiceInterface {

    Vehicle registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId);

}
