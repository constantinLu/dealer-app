package com.dealer.repository.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("DealerApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


    }


}
