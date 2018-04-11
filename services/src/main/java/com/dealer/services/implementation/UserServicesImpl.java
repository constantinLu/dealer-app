package com.dealer.services.implementation;


import com.dealer.commons.dto.User;
import com.dealer.repository.inter.UserRepositoryInteface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserServicesImpl {

    @EJB
    private UserRepositoryInteface userRepositoryInteface;

    public User checUser(String username) {
        User temp = userRepositoryInteface.getUser(username);
        return temp;
    }

}
