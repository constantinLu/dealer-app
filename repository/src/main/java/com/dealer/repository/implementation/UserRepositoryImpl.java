package com.dealer.repository.implementation;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInteface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//https://www.tutorialspoint.com/ejb/ejb_stateless_beans.htm

@Stateless
public class UserRepositoryImpl implements UserRepositoryInteface {

    @PersistenceContext(unitName = "dealers")
    private EntityManager em;

    public User convert(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }


    public User getUser(String username) {
        UserEntity user = (UserEntity) em.createNamedQuery("UserEntity.getName").setParameter("username",username).getSingleResult();
        User userDTO = convert(user);
        return userDTO;

    }
}
