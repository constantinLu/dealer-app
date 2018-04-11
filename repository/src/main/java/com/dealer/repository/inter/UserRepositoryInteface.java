package com.dealer.repository.inter;

import com.dealer.commons.dto.User;

import javax.ejb.Local;

/*
Declares the local business interface(s) for a session bean.
The Local annotation is applied to the session bean class or local business interface to designate a local interface of the bean.
When used on the bean class, declares the local business interface(s) for a session bean. When used on an interface, designates that interface as a local business interface. In this case, no value element should be provided.
The Local annotation applies only to session beans and their interfaces.
 */
@Local
public interface UserRepositoryInteface {

    User getUser(String username);
}
