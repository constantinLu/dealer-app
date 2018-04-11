package com.dealer.services.inter;

import com.dealer.commons.dto.User;

import javax.ejb.Local;

@Local
public interface UserServicesInterface {

    User checkUser(String username);
}
