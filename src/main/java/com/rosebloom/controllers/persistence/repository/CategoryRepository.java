package com.rosebloom.controllers.persistence.repository;

import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class CategoryRepository {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public int getCategoryIdByname(String CategoryName) {
        System.out.println(CategoryName + "*");
        Query query = entityManager.createQuery("select c.categoryId from Category c where c.categoryName =?1")
                .setParameter(1,
                        CategoryName);

        List<Integer> result = query.getResultList();
        return result.get(0);
    }

    public String getCategoryNameByProductId(int id) {
        Query query = entityManager.createQuery("select c from Category c join c.products p  where p.id =?1 ")
                .setParameter(1,
                        id);
        List<Category> result = query.getResultList();
        for (Category category : result) {
            System.out.println(category.getCategoryName());
            System.out.println(category.getCategories());
        }
        if (result.size() == 1) {
            return result.get(0).getCategoryName();
        } else {
            for (Category category : result) {
                if (category.getCategories().isEmpty())
                    return category.getCategoryName();

            }
        }
        return null;
    }

    // public void setCategory(String categoryName, int productId) {
    //     Query query = entityManager.createQuery("select c from Category c join c.products p  where p.id =?1 ")
    //             .setParameter(1,
    //                     productId);
    //     List<Category> result = query.getResultList();
    //     for (Category category : result) {
    //         if (category.getCategoryName().equals(categoryName)) {
    //             return;
    //         }
    //     }
    //     getParentByCategoryName(categoryName);
    // }

    public List<Category> getParentByCategoryName(String categoryName) {

        Query query = entityManager.createQuery("select c from Category c   where c.categoryName =?1 ")
                .setParameter(1,
                        categoryName);
        List<Category> result = query.getResultList();
        return result;
    }

}
