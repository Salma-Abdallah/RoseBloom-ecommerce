package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.CartId;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link CartId} entity
 */
public class CartIdDto implements Serializable {
    private int productId;
    private int userId;

    public CartIdDto() {
    }

    public CartIdDto(int productId, int userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartIdDto entity = (CartIdDto) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, userId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "productId = " + productId + ", " +
                "userId = " + userId + ")";
    }
}