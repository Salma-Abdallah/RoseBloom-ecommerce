package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.ProductImageDto;
import com.rosebloom.controllers.persistence.entities.ProductImage;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ProductImageMapper {
    ProductImage toEntity(ProductImageDto productImageDto);

    ProductImageDto toDto(ProductImage productImage);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductImage partialUpdate(ProductImageDto productImageDto, @MappingTarget ProductImage productImage);
}