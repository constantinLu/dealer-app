package com.dealer.services.inter;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;

import javax.ejb.Local;

@Local
public interface UserServiceInterface {
    public User checkUser(String username);
    public User registerUser(String username, String password);
}
