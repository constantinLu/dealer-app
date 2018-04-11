package com.dealer.repository.inter;

import com.dealer.commons.dto.User;

import javax.ejb.Local;

@Local
public interface UserRepositoryInterface {
    public User getUser(String username);
}
