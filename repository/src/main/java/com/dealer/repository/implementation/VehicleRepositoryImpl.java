package com.dealer.repository.implementation;

import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class VehicleRepositoryImpl implements VehicleRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;


    //adding vehicle to database
    public VehicleEntity registerVehicle(String model, String brand, Color color, double price, String condition, int userId) {

        VehicleEntity vehicleEntity = new VehicleEntity(model, brand, color, price, condition, userId);
        em.persist(vehicleEntity);
        em.flush();
        return vehicleEntity;
    }
}

