package com.dealer.repository.inter;

import com.dealer.repository.entities.UserEntity;

import javax.ejb.Local;

@Local
public interface UserRepositoryInterface {
    UserEntity getUser(String username);
    UserEntity registerUser(String username, String password);
}
