package com.dealer.repository.implementation;

import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.entities.VehicleEntity;
import com.dealer.repository.inter.VehicleRepositoryInterface;
import com.dealer.repository.utils.Color;
import com.dealer.repository.utils.Condition;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Iterator;
import java.util.List;

@Stateless
public class VehicleRepositoryImpl implements VehicleRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;

    public VehicleEntity registerVehicle(String model, String brand, Color color, double price, Condition condition, int userId) {
        VehicleEntity vehicleEntity = new VehicleEntity(model, brand, color, price, condition, userId);
        em.persist(vehicleEntity);
        em.flush();
        return vehicleEntity;
    }


    public VehicleEntity registerVehicle(VehicleEntity vehicleEntity) {
        em.persist(vehicleEntity);
        em.flush();
        return vehicleEntity;
    }

    public void importVehicles(List<VehicleEntity> vehicleEntityList) {
        Iterator<VehicleEntity> iterator = vehicleEntityList.iterator();
        while (iterator.hasNext()) {
            em.persist(iterator.next());
            em.flush();
        }
    }

    public List<VehicleEntity> getVehicleList() {
        List<VehicleEntity> vehicleEntityList = em.createNamedQuery("VehicleEntity.getVehicle", VehicleEntity.class).getResultList();
        return vehicleEntityList;
    }


}

