package com.dealer.repository.implementation;


import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UsersEntity;
import com.dealer.repository.inter.UserRepositoryInterface;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class UserRepository implements UserRepositoryInterface {

    @PersistenceContext(unitName = "myapp")
    private EntityManager em;


    public User convert(UsersEntity usersEntity){
        return new User(usersEntity.getId(),usersEntity.getUsername(),usersEntity.getPassword());
    }

    public User getUser(String username) {
        UsersEntity user= (UsersEntity) em.createNamedQuery("UsersEntity.getUsername").setParameter("name",username).getSingleResult();
        User userDto=convert(user);
        return userDto;
    }
}