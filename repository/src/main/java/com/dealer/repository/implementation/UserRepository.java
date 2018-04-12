package com.dealer.repository.implementation;


import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInterface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepository implements UserRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;


    public User convert(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }

    public User getUser(String username) {
        UserEntity user= (UserEntity) em.createNamedQuery("UserEntity.getUsername").setParameter("name",username).getSingleResult();
        User userDto=convert(user);
        return userDto;
    }
}