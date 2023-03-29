package com.rosebloom.controllers.services;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rosebloom.controllers.mappers.ProductMapper;
import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.repository.CategoryRepository;
import com.rosebloom.controllers.persistence.repository.ProductRepository;
import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.dtos.ProductDto;
import com.rosebloom.dtos.ProductImageDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@MultipartConfig
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

   public void updateProduct(String categoryName, ProductDto productDto) {
      CategoryRepository categoryRepository = new CategoryRepository();
      List<Category> category = categoryRepository.getParentByCategoryName(categoryName);
      Set<Category> setCategories = new HashSet<>(category);
      ProductMapper productMapper = new ProductMapper();
      Product product = productMapper.toEntity(productDto);
      product.setCategories(setCategories);
      ProductRepository pRepository = new ProductRepository();
      pRepository.editProduct(product);
   }

   public void deleteProduct(int id) {
      System.out.println(id);
      productRepository = new ProductRepository();
      productRepository.deleteProduct(id);
   }


   public void getAddProductRequest(HttpServletRequest request, String contextPath,boolean isAdd)
         throws ServletException, IOException {

      List<ProductImageDto> productImageDto = new ArrayList<>();
      for (int i = 1; i <= 3; i++) {
         String inFileName = "fileInput" + (i);
         System.out.println(inFileName);
         final Part filePart = request.getPart(inFileName);
         final String fileName = getFileName(filePart);
         if (fileName.equals("")&&!isAdd) {
            String img = "img" + i;
            if (!request.getParameter(img).equals("")) {
               ProductImageDto productImageDto2 = new ProductImageDto(request.getParameter(img));
               productImageDto.add(productImageDto2);
            }
         } else  if (!fileName.equals("")) {
            filePart.write(contextPath + fileName);
            ProductImageDto productImageDto2 = new ProductImageDto("view/images/" + fileName);
            productImageDto.add(productImageDto2);
         }
      }
      for (ProductImageDto productImageDto2 : productImageDto) {
         System.out.println(productImageDto2);
      }

      System.out.println("**");
      // System.out.println(path + fileName);
      String categoryName = (request.getParameter("categoryOption"));
      ProductDto productDto = new ProductDto();
      if(!isAdd)
      productDto.setId(Integer.parseInt(request.getParameter("productId")));
      productDto.setName(request.getParameter("name"));
      productDto.setCreatedAt(new Timestamp(System.currentTimeMillis()));
      productDto.setDescription(request.getParameter("description"));
      productDto.setPrice(Integer.parseInt(request.getParameter("price")));
  //    productDto.setOldPrice(Integer.parseInt(request.getParameter("oldPrice")));
      productDto.setColor(request.getParameter("color"));
      productDto.setSize(Integer.parseInt(request.getParameter("size")));
      productDto.setPlantdescription(new PlantdescriptionDto());
      productDto.setProductImages(productImageDto);
      productDto.setQuantity(Integer.parseInt(request.getParameter("stock")));
      productDto.setCategory(categoryName);
      productDto.setType(categoryName);
      PlantdescriptionDto plantdescriptionDto=new PlantdescriptionDto();
      productDto.setPlantdescription(plantdescriptionDto);
      ProductServices productServices = new ProductServices();
      if(isAdd) {
         productServices.addProduct(categoryName, productDto);
      }
      else
         productServices.updateProduct(categoryName, productDto);
      System.out.println(request.getParameter("img1"));
   }

   private String getFileName(final Part part) {
      for (String content : part.getHeader("content-disposition").split(";")) {
         if (content.trim().startsWith("filename")) {
            return content.substring(
                  content.indexOf('=') + 1).trim().replace("\"", "");
         }
      }
      return null;
   }

   public void addProduct(String categoryName, ProductDto productDto) {
      CategoryRepository categoryRepository = new CategoryRepository();
      List<Category> category = categoryRepository.getParentByCategoryName(categoryName);
      Set<Category> setCategories = new HashSet<>(category);
      ProductMapper productMapper = new ProductMapper();
      Product product = productMapper.toEntity(productDto);
      product.setCategories(setCategories);
      ProductRepository pRepository = new ProductRepository();
     
      pRepository.addProduct(product);
   }
   public boolean isPlant(int id){
      ProductRepository pRepository = new ProductRepository();
     
     return pRepository.isPlant(id);
   }
}
