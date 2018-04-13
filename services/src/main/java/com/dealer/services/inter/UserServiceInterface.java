package com.dealer.services.inter;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;

import javax.ejb.Local;

@Local
public interface UserServiceInterface {
     User checkUser(String username);
     User registerUser(String username, String password);
}
