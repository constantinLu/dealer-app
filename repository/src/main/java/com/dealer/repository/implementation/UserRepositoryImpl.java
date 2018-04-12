package com.dealer.repository.implementation;


import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInterface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepositoryImpl implements UserRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;


    public User convert(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }

    public UserEntity getUser(String username) {
        UserEntity userEntity = (UserEntity) em.createNamedQuery("UserEntity.getUsername").setParameter("name",username).getSingleResult();
        return userEntity;
    }
}