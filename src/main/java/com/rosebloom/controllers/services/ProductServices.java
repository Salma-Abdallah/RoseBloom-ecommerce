package com.rosebloom.controllers.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rosebloom.controllers.mappers.ProductMapper;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.repository.CategoryRepository;
import com.rosebloom.controllers.persistence.repository.ProductRepository;
import com.rosebloom.dtos.ProductDto;

public class ProductServices {
   CategoryRepository categoryRepository;
   ProductRepository productRepository;

   public List<ProductDto> getProducts(String categoryName) {
      System.out.println(categoryName);
      categoryRepository = new CategoryRepository();
      int categoryId = categoryRepository.getCategoryIdByname(categoryName);
      System.out.println(categoryId);
      productRepository = new ProductRepository();

      List<Product> result = productRepository.getProductByCategoryId(categoryId);
      for (Product p : result) {
         System.out.println(p.getName());
      }
      System.out.println("-------------------------");
      List<ProductDto> productDto = new ArrayList<>();
      ProductMapper mapper = new ProductMapper();
      for (Product product : result) {
         productDto.add(mapper.toDto(product));
      }
      for (ProductDto product : productDto) {
         System.out.println(product);
      }
      return productDto;
   }

   public ProductDto getProductDetails(int id) {
      ProductRepository productRepository = new ProductRepository();

      Product result = productRepository.getProductById(id);
      ProductMapper mapper = new ProductMapper();
      return mapper.toDto(result);
   }

   public List<ProductDto> getAllProducts() {
      productRepository = new ProductRepository();

      List<Product> result = productRepository.getAllProduct();
     
      
      List<ProductDto> productDto = new ArrayList<>();
      ProductMapper mapper = new ProductMapper();
      for (Product product : result) {
         productDto.add(mapper.toDto(product));
      }
      for (ProductDto product : productDto) {
         System.out.println(product);
      }
      return productDto;
   }
   public void updateProduct(String categoryName,ProductDto productDto) {
      CategoryRepository categoryRepository=new CategoryRepository();
      List<Category> category=categoryRepository.getParentByCategoryName(categoryName);
      Set<Category> setCategories = new HashSet<>(category);
      ProductMapper productMapper=new ProductMapper();
      Product product=productMapper.toEntity(productDto);
      product.setCategories(setCategories);
      ProductRepository pRepository=new ProductRepository();
      pRepository.editProduct(product);
   }
   public void deleteProduct(int id) {
      System.out.println(id);
      productRepository=new ProductRepository();
      productRepository.deleteProduct(id);
   }
}
