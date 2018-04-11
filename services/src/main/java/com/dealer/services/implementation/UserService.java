package com.dealer.services.implementation;

import com.dealer.commons.dto.User;
import com.dealer.repository.inter.UserRepositoryInterface;
import com.dealer.services.inter.UserInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService implements UserInterface {

    @EJB
    private UserRepositoryInterface userRepository;

    public User checkUser(String username) {
        User temp_user=userRepository.getUser(username);
        return temp_user;
    }
}
