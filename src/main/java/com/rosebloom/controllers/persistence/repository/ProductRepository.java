package com.rosebloom.controllers.persistence.repository;

import java.util.List;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class ProductRepository  {

    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
   
    public List<Product> getProductByCategoryId(int id) {
      
        Category c=new Category();
        c.setCategoryId(id);
        Query query = entityManager.createQuery("from Product p where ?1 member of p.categories").setParameter(1, c);
       
        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }

   
    public Product getProductById(int id) {
        Query query = entityManager.createQuery("from Product p where id=?1").setParameter(1, id);
       
        List<Product> result = (List<Product>) query.getResultList();
        return result.get(0);
    }

    // @Override
    // public void addProduct(Product product) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    // }

    // @Override
    // public List<Product> getAllProducts() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    // }

    // @Override
    // public void editProduct(Product product) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'editProduct'");
    // }

}
