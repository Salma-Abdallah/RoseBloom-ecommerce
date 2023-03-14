package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Category;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Category} entity
 */
public class CategoryDto implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private Set<ProductDto> products;

    public CategoryDto() {
    }

    public CategoryDto(Integer categoryId, String categoryName, Set<ProductDto> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.categoryName, entity.categoryName) &&
                Objects.equals(this.products, entity.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, products);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryId = " + categoryId + ", " +
                "categoryName = " + categoryName + ", " +
                "products = " + products + ")";
    }
}