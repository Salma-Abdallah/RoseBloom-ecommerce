package com.rosebloom.controllers.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.ProductImage;
import com.rosebloom.controllers.persistence.entities.ProductImageId;
import com.rosebloom.dtos.ProductImageDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class ProductRepository {

    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Product> getProductByCategoryId(int id) {

        Category c = new Category();
        c.setCategoryId(id);
        Query query = entityManager.createQuery("from Product p where ?1 member of p.categories and p.isDeleted=0")
                .setParameter(1, c);

        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }

    public Product getProductById(int id) {
        Product product = entityManager.find(Product.class, id);
        // Query query = entityManager.createQuery("from Product p where
        // id=?1").setParameter(1, id);

        // List<Product> result = (List<Product>) query.getResultList();
        return product;
    }

    public List<Product> getAllProduct() {
        Query query = entityManager.createQuery("from Product p where p.isDeleted=0 ");

        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }

    public void editProduct(Product product) {
        Product product1 = entityManager.find(Product.class, product.getId());
        editProductImage(new ArrayList<>(product.getProductImages()), product.getId());

        entityManager.getTransaction().begin();
        // product1.setCategory(product.getCategory());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setOldPrice(product.getOldPrice());
        product1.setQuantity(product.getQuantity());
        product1.setDescription(product.getDescription());
        // product1.setProductImages(product.getProductImages());
        // for (ProductImage img : product.getProductImages()) {
        // System.out.println(img.getImage());

        // }
        // for (ProductImage img : product1.getProductImages()) {
        // System.out.println(img.getImage());

        // }
        product1.setCategories(product.getCategories());
        product1.setCreatedAt(product.getCreatedAt());
        product1.setSize(product.getSize());
        product1.setColor(product.getColor());
        // product1.setPlantdescription(product.getPlantdescription());
        entityManager.getTransaction().commit();
        for (ProductImage img : product1.getProductImages()) {
            System.out.println(img.getImage());

        }
    }

    private void editProductImage(List<ProductImage> productImages, int pId) {
        Query query = entityManager.createQuery("from ProductImage p where p.product.id=?1").setParameter(1, pId);

        List<ProductImage> result = (List<ProductImage>) query.getResultList();
        System.out.println(result.size());
        System.out.println(productImages.size());
        for (int i = 0; i < result.size(); i++) {
            ProductImageId productImageId = new ProductImageId(result.get(i).getId().getImgId(), pId);
            ProductImage productImg = entityManager.find(ProductImage.class, productImageId);
            entityManager.getTransaction().begin();
            productImg.setImage(productImages.get(i).getImage());
            entityManager.getTransaction().commit();
            // System.out.println(productImage.getId().getImgId());
        }
        if (productImages.size() > result.size()) {
            for (int i = result.size(); i < productImages.size(); i++) {
                System.out.println(productImages.get(i));
                ProductImageId productImageId = new ProductImageId();
                productImageId.setProductId(pId);
                productImages.get(i).setId(productImageId);
                entityManager.getTransaction().begin();
                entityManager.persist(productImages.get(i));
                entityManager.getTransaction().commit();
            }
        }

    }

    public void deleteProduct(int pId) {
        System.out.println(pId);
        Product product = entityManager.find(Product.class, pId);
        entityManager.getTransaction().begin();
        product.setIsDeleted(1);
        entityManager.getTransaction().commit();
        System.out.println(pId);

    }
    // @Override
    // public void addProduct(Product product) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    // }

}