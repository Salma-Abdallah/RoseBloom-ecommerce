package com.rosebloom.controllers.persistence.repository;

import java.util.List;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class CategoryRepository {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public int getCategoryIdByname(String CategoryName) {
System.out.println(CategoryName+"*");
        Query query = entityManager.createQuery("select c.categoryId from Category c where c.categoryName =?1").setParameter(1,
                CategoryName);

        List<Integer> result =query.getResultList();
        return result.get(0);
    }
}
