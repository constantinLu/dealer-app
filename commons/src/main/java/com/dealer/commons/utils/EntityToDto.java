package com.dealer.commons.utils;

import com.dealer.commons.dto.User;
import com.dealer.repository.entities.UserEntity;

public class EntityToDto {

    //EntityToDTO
    public static User convert(UserEntity userEntity){
        // set the id also
        return new User(userEntity.getUsername(), userEntity.getPassword());
    }

}
