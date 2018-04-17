package com.dealer.services.implementation;

import com.dealer.commons.dto.User;
import com.dealer.commons.utils.EntityToDto;
import com.dealer.repository.entities.UserEntity;
import com.dealer.repository.inter.UserRepositoryInterface;
import com.dealer.services.inter.UserServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserServiceImpl implements UserServiceInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    //converting to userDTO
    public User checkUser(String username) {
        UserEntity  tempUser = userRepository.getUser(username);
        return EntityToDto.convert(tempUser);
    }

    //converting to userDTO
    public User registerUser(String username, String password){
        UserEntity user = userRepository.registerUser(username, password);
        return EntityToDto.convert(user);
    }
}
