package com.rosebloom.models.dtos;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto {
    private Integer categoryId;
    private CategoryDto parentCategory;
    private String categoryName;
    private Integer isDeleted;
    private Set<CategoryDto> categories = new HashSet<>(0);
    private Set<ProductDto> products = new HashSet<>();

    public CategoryDto() {
    }

	
    public CategoryDto(CategoryDto category, String categoryName) {
        this.parentCategory = category;
        this.categoryName = categoryName;
    }
    public CategoryDto(CategoryDto category, String categoryName, Integer isDeleted, Set<CategoryDto> categories, Set<ProductDto> products) {
       this.parentCategory = category;
       this.categoryName = categoryName;
       this.isDeleted = isDeleted;
       this.categories = categories;
       this.products = products;
    }
   
   
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

   
    public CategoryDto getParentCategory() {
        return this.parentCategory;
    }
    
    public void setParentCategory(CategoryDto category) {
        this.parentCategory = category;
    }

    
   
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
  
    public Integer getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

  
    public Set<CategoryDto> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }

    public Set<ProductDto> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

}
