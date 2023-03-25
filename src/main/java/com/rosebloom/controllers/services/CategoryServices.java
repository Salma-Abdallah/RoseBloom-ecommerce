package com.rosebloom.controllers.services;


import com.rosebloom.controllers.persistence.repository.CategoryRepository;

public class CategoryServices {
    public String getCategoryName(int id) {
        CategoryRepository categoryRepository=new CategoryRepository();
        String category=categoryRepository.getCategoryNameByProductId(id);
        return category;
    }
    public void updateProductCategory(String categoryName,int productId) {

    }
}
