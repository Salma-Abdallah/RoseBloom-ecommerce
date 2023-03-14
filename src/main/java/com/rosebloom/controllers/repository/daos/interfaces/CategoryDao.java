package com.rosebloom.controllers.repository.daos.interfaces;

import java.util.List;

import com.rosebloom.controllers.persistence.entities.Category;

public interface CategoryDao {
    public List<Category> getCategoryById(int catId);
    public List<Category> getAllCategories();
    public int getCategoryByName(String name);
}
