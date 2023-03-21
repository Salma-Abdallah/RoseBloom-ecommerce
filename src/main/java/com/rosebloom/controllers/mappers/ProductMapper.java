package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.dtos.ProductDto;
import com.rosebloom.dtos.ProductImageDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rosebloom.controllers.persistence.entities.Plantdescription;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.ProductImage;

public class ProductMapper {

    public ProductDto toDto(Product product) {
        PlantdescriptionMapper plantdescriptionMapper = new PlantdescriptionMapper();
        Plantdescription plantdescription = product.getPlantdescription();
        PlantdescriptionDto PlantdescriptionDto = plantdescriptionMapper.toDto(plantdescription);
        ProductImageMapper productImageMapper = new ProductImageMapper();
        Set<ProductImage> productImage = product.getProductImages();
        Set<ProductImageDto> productImageDto = new HashSet<>();
        for (ProductImage productImg : productImage) {
            productImageDto.add(productImageMapper.toDto(productImg));
        }
        List<ProductImageDto> productImageDto2=new ArrayList<ProductImageDto>(productImageDto);
        ProductDto productDto = new ProductDto(product.getId(), product.getPrice(), product.getName(),
                product.getQuantity(), product.getType(), product.getCategory(), product.getDescription(),
                product.getColor(),
                product.getSize(), product.getOldPrice(), product.getCreatedAt(), PlantdescriptionDto, productImageDto2);

        return productDto;
    }

    public Product toEntity(ProductDto productDto) {
        PlantdescriptionMapper plantdescriptionMapper = new PlantdescriptionMapper();
        PlantdescriptionDto plantdescriptionDto = productDto.getPlantdescription();
        Plantdescription Plantdescription = plantdescriptionMapper.toEntity(plantdescriptionDto);
        ProductImageMapper productImageMapper = new ProductImageMapper();
        Set<ProductImageDto> productImageDto = productDto.getProductImages();
        Set<ProductImage> productImage = new HashSet<>();
        for (ProductImageDto productImg : productImageDto) {
            productImage.add(productImageMapper.toEntity(productImg));
        }

        Product product = new Product(productDto.getId(), productDto.getPrice(), productDto.getName(),
                productDto.getQuantity(), productDto.getType(), productDto.getCategory(), productDto.getDescription(),
                productDto.getColor(),
                productDto.getSize(), productDto.getOldPrice(), productDto.getCreatedAt(), Plantdescription,
                productImage);

        return product;
    }
}

// import org.mapstruct.*;
// import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel =
// MappingConstants.ComponentModel.CDI)
// public interface ProductMapper {
// public Product toEntity(ProductDto productDto);

// public ProductDto toDto(Product product);
// public ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );
// @BeanMapping(nullValuePropertyMappingStrategy =
// NullValuePropertyMappingStrategy.IGNORE)
// public Product partialUpdate(ProductDto productDto, @MappingTarget Product
// product);
// }