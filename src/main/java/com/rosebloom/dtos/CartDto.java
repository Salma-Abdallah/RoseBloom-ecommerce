package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Cart;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Cart} entity
 */
public class CartDto implements Serializable {
    private CartIdDto id;
    private ProductDto product;
//    private UserDto user;
    private Integer quantity;

    public CartDto() {
    }

    public CartDto(CartIdDto id, ProductDto product, Integer quantity) { //, UserDto user
        this.id = id;
        this.product = product;
//        this.user = user;
        this.quantity = quantity;
    }

    public CartIdDto getId() {
        return id;
    }

    public void setId(CartIdDto id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

//    public UserDto getUser() {
//        return user;
//    }
//
//    public void setUser(UserDto user) {
//        this.user = user;
//    }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto entity = (CartDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.product, entity.product) &&
                this.quantity == entity.getQuantity(); //&&
//                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product);
    } //, user

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "product = " + product + ", " +
                "quantity = " + quantity +
//                ", " + "user = " + user +
                ")";
    }

}