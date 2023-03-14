package com.rosebloom.controllers.repository.daos.interfaces;

import java.util.List;

import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;



public interface ProductDao {
    
    public List<Product> getProductByCategory(Category category);
    public void getProductById(int id);
    public void addProduct(Product product);
    public void editProduct(Product product);
    public List<Product> getAllProducts();


}
