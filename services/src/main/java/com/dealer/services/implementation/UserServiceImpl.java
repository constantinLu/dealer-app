package com.dealer.services.implementation;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInterface;
import com.dealer.services.inter.UserServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserServiceImpl implements UserServiceInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    public UserEntity checkUser(String username) {
        UserEntity temp_user=userRepository.getUser(username);
        return temp_user;
    }
}
