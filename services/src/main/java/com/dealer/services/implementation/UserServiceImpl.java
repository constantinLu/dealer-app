package com.dealer.services.implementation;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.implementation.UserRepositoryImpl;
import com.dealer.repository.inter.UserRepositoryInterface;
import com.dealer.services.inter.UserServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserServiceImpl implements UserServiceInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    public User checkUser(String username) {
        UserEntity  tempUser = userRepository.getUser(username);
        return userRepository.convert(tempUser);
    }
}
