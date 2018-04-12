package com.dealer.commons.utils;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;


public class DtoToEntity {

    // set id also
    public static UserEntity convertToEntity(User user) {
        return new UserEntity(user.getUsername(), user.getPassword());
    }

}
