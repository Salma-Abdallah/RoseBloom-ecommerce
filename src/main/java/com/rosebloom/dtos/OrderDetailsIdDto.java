package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.OrderDetailsId;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link OrderDetailsId} entity
 */
public class OrderDetailsIdDto implements Serializable {
    private int orderId;
    private int productId;

    public OrderDetailsIdDto() {
    }

    public OrderDetailsIdDto(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsIdDto entity = (OrderDetailsIdDto) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "orderId = " + orderId + ", " +
                "productId = " + productId + ")";
    }
}