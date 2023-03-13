package com.rosebloom.controllers.repository.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EntityManagerFactorySingleton {

    private static EntityManagerFactory instance;
    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance(){

        if(instance == null){
            instance = Persistence.createEntityManagerFactory("roseBloom");
        }

        return instance;
    }

}