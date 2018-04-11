package com.dealer.services.inter;

import com.dealer.commons.dto.User;

import javax.ejb.Local;

@Local
public interface UserInterface {
    public User checkUser(String username);
}
