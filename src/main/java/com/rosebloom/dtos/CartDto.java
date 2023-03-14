package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Cart;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Cart} entity
 */
public class CartDto implements Serializable {
    private ProductDto product;

    public CartDto() {
    }

    public CartDto(ProductDto product) {
        this.product = product;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto entity = (CartDto) o;
        return Objects.equals(this.product, entity.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "product = " + product + ")";
    }
}