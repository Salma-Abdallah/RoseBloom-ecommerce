package com.rosebloom.controllers.repository.daos;

import java.util.List;

import com.rosebloom.controllers.repository.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.repository.daos.interfaces.ProductDao;
import com.rosebloom.models.entities.Category;
import com.rosebloom.models.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class ProductDaoImpl implements ProductDao {

    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Product> getProductByCategory(int catId) {
      
        
        Query query = entityManager.createQuery("from Product p where ?1 member of p.categories");
        Category category=new Category();
        category.setCategoryId(catId);
        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }

    @Override
    public void getProductById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public void editProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editProduct'");
    }

}
