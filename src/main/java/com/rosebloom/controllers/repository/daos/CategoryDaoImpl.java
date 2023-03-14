package com.rosebloom.controllers.repository.daos;

import java.util.List;

import com.rosebloom.controllers.repository.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.repository.daos.interfaces.CategoryDao;
import com.rosebloom.models.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class CategoryDaoImpl implements CategoryDao {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Category> getAllCategories() {
        Query query = entityManager.createQuery("from Category c");
        List<Category> result = (List<Category>) query.getResultList();
        return result;
    }
    @Override
    public List<Category> getCategoryById(int catId) {
        Query query = entityManager.createQuery("from Category c where c.id= ?1");
        Category category=new Category();
        category.setCategoryId(catId);
        List<Category> result = (List<Category>) query.getResultList();
        return result;
    }
    
    public int getCategoryByName(String name) {
        Query query = entityManager.createQuery("select c.categoryId from Category c where c.name= ?1");
        Category category=new Category();
        category.setCategoryName(name);
        List<Integer> result = (List<Integer>) query.getResultList();
        return result.get(0);
    }
    
    
}
