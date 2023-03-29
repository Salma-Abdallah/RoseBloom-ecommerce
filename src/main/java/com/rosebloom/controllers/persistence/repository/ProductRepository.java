package com.rosebloom.controllers.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Plantdescription;
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
        Query query = entityManager.createQuery("from Product p where ?1 member of p.categories and p.isDeleted=0 and p.quantity>0")
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
        Query query = entityManager.createQuery("from Product p where p.isDeleted=0  order by p.createdAt desc");

        List<Product> result = (List<Product>) query.getResultList();
        return result;
    }

    public void editProduct(Product product) {
        Product product1 = entityManager.find(Product.class, product.getId());
        editProductImage(new ArrayList<>(product.getProductImages()), product.getId());

        entityManager.getTransaction().begin();
        // product1.setCategory(product.getCategory());
        //product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        //product1.setOldPrice(product.getOldPrice());
        product1.setQuantity(product.getQuantity());
        //product1.setDescription(product.getDescription());
        // product1.setProductImages(product.getProductImages());
        // for (ProductImage img : product.getProductImages()) {
        // System.out.println(img.getImage());

        // }
        // for (ProductImage img : product1.getProductImages()) {
        // System.out.println(img.getImage());

        // }
        //product1.setCategories(product.getCategories());
        //product1.setCreatedAt(product.getCreatedAt());
        //product1.setSize(product.getSize());
        //product1.setColor(product.getColor());
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

    public void addProduct(Product product) {
        product.setIsDeleted(0);
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        System.out.println(product.getId());
       
        //entityManager.persist(product);
       // ProductImage productImage = new ProductImage();
       
        product.getPlantdescription().setProductId(product.getId());
        // Plantdescription plantdescription =new Plantdescription();
        // plantdescription.setProductId(26);
        //entityManager.persist(plantdescription);
        //System.out.println(product.getId());
        entityManager.getTransaction().commit();
        
        List<ProductImage> productImages = new ArrayList<>(product.getProductImages());
        for (ProductImage productImage2 : productImages) {
            System.out.println(productImage2);
        }
        for (int i = 0; i < product.getProductImages().size(); i++) {
            ProductImage productImage  = new ProductImage();
         //   productImages.get(i);
            productImage.setImage(productImages.get(i).getImage());
            //productImage.setProduct(product);
            ProductImageId productImageId = new ProductImageId();
            productImageId.setProductId(product.getId());
           productImage.setId(productImageId);
           // productImage.setProduct(product);
            entityManager.getTransaction().begin();
            entityManager.persist(productImage);
            entityManager.getTransaction().commit();
           
            entityManager.clear();
            
        }
        entityManager.getTransaction().begin();
        Plantdescription plantdescription2=new Plantdescription();
        //plantdescription2.setProductId(product.getId());
        plantdescription2.setProduct(product);
        plantdescription2.setGrowthCycle(product.getPlantdescription().getGrowthCycle());
        plantdescription2.setSoil(product.getPlantdescription().getSoil());
        plantdescription2.setGrowthRate(product.getPlantdescription().getGrowthRate());
        plantdescription2.setSun(product.getPlantdescription().getSun());
        plantdescription2.setWater(product.getPlantdescription().getWater());
        plantdescription2.setMaintenance(product.getPlantdescription().getMaintenance());
        System.out.println(plantdescription2.getProductId()); 
        System.out.println(plantdescription2.getProduct().getId()); 
        //entityManager.getTransaction().commit();
       
            entityManager.persist(plantdescription2);
            
        
        entityManager.getTransaction().commit();
    }
    public boolean isPlant(int productId){
        Query query = entityManager.createQuery("select c.categoryName from Product p join Category c  where p.product.id=?1").setParameter(1, productId);
        List<String> result = (List<String>) query.getResultList();
        for (String categoryName : result) {
            if(categoryName.equals("Plants"))
                return true;
        }
        return false;
    }

}