package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.ProductImageDto;
import com.rosebloom.controllers.persistence.entities.ProductImage;
public class ProductImageMapper{
    ProductImage toEntity(ProductImageDto productImageDto) {
        return new ProductImage(productImageDto.getImage());
    }
    ProductImageDto toDto(ProductImage productImage) {
        return new ProductImageDto(productImage.getImage());
    }
}
// import org.mapstruct.*;
// import org.mapstruct.Mapper;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
// public interface ProductImageMapper {
//     ProductImage toEntity(ProductImageDto productImageDto);

//     ProductImageDto toDto(ProductImage productImage);

//     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//     ProductImage partialUpdate(ProductImageDto productImageDto, @MappingTarget ProductImage productImage);
// }