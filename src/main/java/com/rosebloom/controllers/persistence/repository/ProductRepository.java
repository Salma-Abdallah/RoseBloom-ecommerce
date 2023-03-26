package com.rosebloom.controllers.persistence.repository;

import java.util.List;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.ProductImage;
import com.rosebloom.dtos.ProductImageDto;

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
        Product product=entityManager.find(Product.class,id);  
        // Query query = entityManager.createQuery("from Product p where id=?1").setParameter(1, id);
       
        // List<Product> result = (List<Product>) query.getResultList();
        return product;
    }
    public List<Product> getAllProduct() {
        Query query = entityManager.createQuery("from Product p ");
       
        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }
  
    public void editProduct(Product product) {
        Product product1=entityManager.find(Product.class,product.getId());  
        
         entityManager.getTransaction().begin();
        // product1.setCategory(product.getCategory());
         product1.setName(product.getName());
         product1.setPrice(product.getPrice());
         product1.setOldPrice(product.getOldPrice());
         product1.setQuantity(product.getQuantity());
         product1.setDescription(product.getDescription());
        product1.setProductImages(product.getProductImages());
        for (ProductImage img : product.getProductImages()) {
            System.out.println(img.getImage());

        }
        for (ProductImage img : product1.getProductImages()) {
            System.out.println(img.getImage());
            
        }
         product1.setCategories(product.getCategories());
         product1.setCreatedAt(product.getCreatedAt());
         product1.setSize(product.getSize());
         product1.setColor(product.getColor());
         //product1.setPlantdescription(product.getPlantdescription());
         entityManager.getTransaction().commit();
         for (ProductImage img : product1.getProductImages()) {
            System.out.println(img.getImage());
            
        }
    }

    // @Override
    // public void addProduct(Product product) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    // }


  

}
