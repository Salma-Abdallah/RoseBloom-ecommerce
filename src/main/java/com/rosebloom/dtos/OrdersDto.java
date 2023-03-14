package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Orders;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Orders} entity
 */
public class OrdersDto implements Serializable {
    private Integer orderId;
    private Timestamp orderDate;
    private String address;
    private String status;
    private Set<OrderDetailsDto> orderDetailses;

    public OrdersDto() {
    }

    public OrdersDto(Integer orderId, Timestamp orderDate, String address, String status, Set<OrderDetailsDto> orderDetailses) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.address = address;
        this.status = status;
        this.orderDetailses = orderDetailses;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderDetailsDto> getOrderDetailses() {
        return orderDetailses;
    }

    public void setOrderDetailses(Set<OrderDetailsDto> orderDetailses) {
        this.orderDetailses = orderDetailses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDto entity = (OrdersDto) o;
        return Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.orderDetailses, entity.orderDetailses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, address, status, orderDetailses);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "orderId = " + orderId + ", " +
                "orderDate = " + orderDate + ", " +
                "address = " + address + ", " +
                "status = " + status + ", " +
                "orderDetailses = " + orderDetailses + ")";
    }
}