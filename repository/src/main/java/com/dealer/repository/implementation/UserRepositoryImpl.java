package com.dealer.repository.implementation;


import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInterface;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepositoryImpl implements UserRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;


    public UserEntity getUser(String username) {
        UserEntity userEntity = (UserEntity) em  .createNamedQuery("UserEntity.getUsername").setParameter("name",username).getSingleResult();
        return userEntity;
    }


    //adding an user to the database
    public UserEntity registerUser(String username, String password) {
        UserEntity user = new UserEntity(username, password);
        // UserEntity registerUser = convertToEntity(user);
        em.persist(user);
        em.flush();
        return user;
    }
}