package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.ProductImage;
import com.rosebloom.dtos.ProductImageDto;

public class ProductImageMapper {
    
    public static ProductImage toEntity(ProductImageDto productImageDto) {
        if ( productImageDto == null ) {
            return null;
        }

        ProductImage productImage = new ProductImage();

        productImage.setImage( productImageDto.getImage() );

        return productImage;
    }
    
    public static ProductImageDto toDto(ProductImage productImage) {
        if ( productImage == null ) {
            return null;
        }

        ProductImageDto productImageDto = new ProductImageDto();

        productImageDto.setImage( productImage.getImage() );

        return productImageDto;
    }
    
    public static ProductImage partialUpdate(ProductImageDto productImageDto, ProductImage productImage) {
        if ( productImageDto == null ) {
            return productImage;
        }

        if ( productImageDto.getImage() != null ) {
            productImage.setImage( productImageDto.getImage() );
        }

        return productImage;
    }
}
