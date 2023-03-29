package com.rosebloom.controllers.services;


import com.rosebloom.controllers.mappers.CartIdMapper;
import com.rosebloom.controllers.mappers.CartMapper;
import com.rosebloom.controllers.persistence.entities.Cart;
import com.rosebloom.controllers.persistence.entities.CartId;
import com.rosebloom.controllers.persistence.repository.CartRepository;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import com.rosebloom.dtos.CartDto;
import com.rosebloom.dtos.CartIdDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartServices {
    CartRepository cartRepository;
    public CartServices(){
        cartRepository = new CartRepository();
    }

    public CustomValidationMessage addCartItem(CartIdDto cartIdDto, Integer quantity){
        return cartRepository.addCartItem(CartIdMapper.toEntity(cartIdDto), quantity);
    }

    public List<CartDto> getAllCartItemsByUserId(int userId){
        List<Cart> cartItemsEntities = cartRepository.getAllCartItemsByUserId(userId);

        return cartItemsEntities.stream().map((cartItemEntity)->
                CartMapper.toDto(cartItemEntity)
        ).collect(Collectors.toList());
    }

    public CustomValidationMessage deleteCartItemByCartId(CartIdDto cartId) {
        return cartRepository.deleteCartItemByCartId(CartIdMapper.toEntity(cartId));
    }

    public CustomValidationMessage changeCartItemQuantity(CartIdDto cartId, Integer quantity){
        return cartRepository.changeCartItemQuantity(CartIdMapper.toEntity(cartId),quantity);
//        return CartMapper.toDto(cartItemReturned);
    }
}
