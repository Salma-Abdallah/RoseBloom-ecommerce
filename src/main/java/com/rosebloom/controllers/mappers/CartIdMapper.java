package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.CartId;
import com.rosebloom.dtos.CartIdDto;


public class CartIdMapper {


    public static CartId toEntity(CartIdDto cartIdDto) {
        if ( cartIdDto == null ) {
            return null;
        }

        CartId cartId = new CartId();

        cartId.setProductId( cartIdDto.getProductId() );
        cartId.setUserId( cartIdDto.getUserId() );

        return cartId;
    }

    public static CartIdDto toDto(CartId cartId) {
        if ( cartId == null ) {
            return null;
        }

        CartIdDto cartIdDto = new CartIdDto();

        cartIdDto.setProductId( cartId.getProductId() );
        cartIdDto.setUserId( cartId.getUserId() );

        return cartIdDto;
    }

    public static CartId partialUpdate(CartIdDto cartIdDto, CartId cartId) {
        if ( cartIdDto == null ) {
            return cartId;
        }

        cartId.setProductId( cartIdDto.getProductId() );
        cartId.setUserId( cartIdDto.getUserId() );

        return cartId;
    }
}
