package com.rosebloom.controllers.services;

import java.util.ArrayList;
import java.util.List;

import com.rosebloom.controllers.mappers.ProductMapper;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.repository.CategoryRepository;
import com.rosebloom.controllers.persistence.repository.ProductRepository;
import com.rosebloom.dtos.ProductDto;

public class ProductServices {

   public List<ProductDto> getProducts(String categoryName) {
      System.out.println(categoryName);
      CategoryRepository categoryRepository = new CategoryRepository();
      int categoryId = categoryRepository.getCategoryIdByname(categoryName);
      System.out.println(categoryId);
      ProductRepository productRepository = new ProductRepository();

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
}
