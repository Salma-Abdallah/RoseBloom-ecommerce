package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.OrderDetails;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link OrderDetails} entity
 */
public class OrderDetailsDto implements Serializable {
    private ProductDto product;
    private Integer quantity;
    private Double price;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(ProductDto product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsDto entity = (OrderDetailsDto) o;
        return Objects.equals(this.product, entity.product) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "product = " + product + ", " +
                "quantity = " + quantity + ", " +
                "price = " + price + ")";
    }
}