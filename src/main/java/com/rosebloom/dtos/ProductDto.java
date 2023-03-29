package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Product;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


/**
 * A DTO for the {@link Product} entity
 */
public class ProductDto implements Serializable {
    private Integer id;
    private int price;
    private String name;
    private int quantity;
    private String type;
    private String category;
    private String description;
    private String color;
    private Integer size;
    private Integer oldPrice;
    private Timestamp createdAt;
    private int isDeleted;
    private PlantdescriptionDto plantdescription;
    private List<ProductImageDto> productImages;

    public ProductDto() {
    }

    public ProductDto(Integer id, int price, String name, int quantity, String type, String category, String description, String color, Integer size, Integer oldPrice, Timestamp createdAt, int isDeleted, PlantdescriptionDto plantdescription, List<ProductImageDto> productImages) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.category = category;
        this.description = description;
        this.color = color;
        this.size = size;
        this.oldPrice = oldPrice;
        this.createdAt = createdAt;
        this.plantdescription = plantdescription;
        this.productImages = productImages;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getIsDeleted() {return isDeleted;}

    public void setIsDeleted(int isDeleted) {this.isDeleted = isDeleted;}

    public PlantdescriptionDto getPlantdescription() {
        return plantdescription;
    }

    public void setPlantdescription(PlantdescriptionDto plantdescription) {
        this.plantdescription = plantdescription;
    }

    public List<ProductImageDto> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImageDto> productImages) {
        this.productImages = productImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.size, entity.size) &&
                Objects.equals(this.oldPrice, entity.oldPrice) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.isDeleted, entity.isDeleted) &&
                Objects.equals(this.plantdescription, entity.plantdescription) &&
                Objects.equals(this.productImages, entity.productImages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, quantity, type, category, description, color, size, oldPrice, createdAt, isDeleted, plantdescription, productImages);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "price = " + price + ", " +
                "name = " + name + ", " +
                "quantity = " + quantity + ", " +
                "type = " + type + ", " +
                "category = " + category + ", " +
                "description = " + description + ", " +
                "color = " + color + ", " +
                "size = " + size + ", " +
                "oldPrice = " + oldPrice + ", " +
                "createdAt = " + createdAt + ", " +
                "isDeleted = " + isDeleted + ", " +
                "plantdescription = " + plantdescription + ", " +
                "productImages = " + productImages + ")";
    }
}