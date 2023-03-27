package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.Cart;
import com.rosebloom.controllers.persistence.entities.CartId;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.User;
import com.rosebloom.dtos.CartDto;


public class CartMapper {

    public static Cart toEntity(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( CartIdMapper.toEntity( cartDto.getId() ) );
        ProductMapper productMapper = new ProductMapper();
        cart.setProduct( productMapper.toEntity( cartDto.getProduct() ) );
//        cart.setUser( UserMapper.toEntity( cartDto.getUser() ) );
        cart.setQuantity( cartDto.getQuantity() );

        return cart;
    }


    public static CartDto toDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( CartIdMapper.toDto( cart.getId() ) );
        ProductMapper productMapper = new ProductMapper();
        cartDto.setProduct( productMapper.toDto( cart.getProduct() ) );
//        cartDto.setUser( UserMapper.toDto( cart.getUser() ) );
        cartDto.setQuantity( cart.getQuantity() );

        return cartDto;
    }


//    public static Cart partialUpdate(CartDto cartDto, Cart cart) {
//        if ( cartDto == null ) {
//            return cart;
//        }
//
//        if ( cartDto.getId() != null ) {
//            if ( cart.getId() == null ) {
//                cart.setId( new CartId() );
//            }
//            CartIdMapper.partialUpdate( cartDto.getId(), cart.getId() );
//        }
//        if ( cartDto.getProduct() != null ) {
//            if ( cart.getProduct() == null ) {
//                cart.setProduct( new Product() );
//            }
//            ProductMapper.partialUpdate( cartDto.getProduct(), cart.getProduct() );
//        }
////        if ( cartDto.getUser() != null ) {
////            if ( cart.getUser() == null ) {
////                cart.setUser( new User() );
////            }
////            UserMapper.partialUpdate( cartDto.getUser(), cart.getUser() );
////        }
//        if ( cartDto.getQuantity() != null ) {
//            cart.setQuantity( cartDto.getQuantity() );
//        }
//
//        return cart;
//    }
}
