package com.dealer.repository.inter;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;

import javax.ejb.Local;

@Local
public interface UserRepositoryInterface {
    public UserEntity getUser(String username);
}
