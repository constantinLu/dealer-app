package com.dealer.services.inter;

import com.dealer.commons.dto.User;
import com.dealer.commons.dto.Vehicle;
import com.dealer.repository.utils.Color;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface VehicleServiceInterface {

    Vehicle registerVehicle(String model, String brand, Color color, double price, String condition, int userId);

}
