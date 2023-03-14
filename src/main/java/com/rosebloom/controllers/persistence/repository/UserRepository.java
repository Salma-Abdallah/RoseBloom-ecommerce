package com.rosebloom.controllers.persistence.repository;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;

import jakarta.persistence.EntityManager;

public class UserRepository {
    EntityManager entityManager;
    public UserRepository(){
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }
    
}
