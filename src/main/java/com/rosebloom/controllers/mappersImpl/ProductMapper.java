package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.Plantdescription;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.ProductImage;
import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.dtos.ProductDto;
import com.rosebloom.dtos.ProductImageDto;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductMapper {


    public static Product toEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setPrice( productDto.getPrice() );
        product.setName( productDto.getName() );
        product.setQuantity( productDto.getQuantity() );
        product.setType( productDto.getType() );
        product.setCategory( productDto.getCategory() );
        product.setDescription( productDto.getDescription() );
        product.setColor( productDto.getColor() );
        product.setSize( productDto.getSize() );
        product.setOldPrice( productDto.getOldPrice() );
        product.setCreatedAt( productDto.getCreatedAt() );
        product.setPlantdescription( plantdescriptionDtoToPlantdescription( productDto.getPlantdescription() ) );
        product.setProductImages( productImageDtoSetToProductImageSet( productDto.getProductImages() ) );

        return product;
    }
    
    public static ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setPrice( product.getPrice() );
        productDto.setName( product.getName() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setType( product.getType() );
        productDto.setCategory( product.getCategory() );
        productDto.setDescription( product.getDescription() );
        productDto.setColor( product.getColor() );
        productDto.setSize( product.getSize() );
        productDto.setOldPrice( product.getOldPrice() );
        productDto.setCreatedAt( product.getCreatedAt() );
        productDto.setPlantdescription( plantdescriptionToPlantdescriptionDto( product.getPlantdescription() ) );
        productDto.setProductImages( productImageSetToProductImageDtoSet( product.getProductImages() ) );

        return productDto;
    }
    
    public static Product partialUpdate(ProductDto productDto, Product product) {
        if ( productDto == null ) {
            return product;
        }

        if ( productDto.getId() != null ) {
            product.setId( productDto.getId() );
        }
        product.setPrice( productDto.getPrice() );
        if ( productDto.getName() != null ) {
            product.setName( productDto.getName() );
        }
        product.setQuantity( productDto.getQuantity() );
        if ( productDto.getType() != null ) {
            product.setType( productDto.getType() );
        }
        if ( productDto.getCategory() != null ) {
            product.setCategory( productDto.getCategory() );
        }
        if ( productDto.getDescription() != null ) {
            product.setDescription( productDto.getDescription() );
        }
        if ( productDto.getColor() != null ) {
            product.setColor( productDto.getColor() );
        }
        if ( productDto.getSize() != null ) {
            product.setSize( productDto.getSize() );
        }
        if ( productDto.getOldPrice() != null ) {
            product.setOldPrice( productDto.getOldPrice() );
        }
        if ( productDto.getCreatedAt() != null ) {
            product.setCreatedAt( productDto.getCreatedAt() );
        }
        if ( productDto.getPlantdescription() != null ) {
            if ( product.getPlantdescription() == null ) {
                product.setPlantdescription( new Plantdescription() );
            }
            plantdescriptionDtoToPlantdescription1( productDto.getPlantdescription(), product.getPlantdescription() );
        }
        if ( product.getProductImages() != null ) {
            Set<ProductImage> set = productImageDtoSetToProductImageSet( productDto.getProductImages() );
            if ( set != null ) {
                product.getProductImages().clear();
                product.getProductImages().addAll( set );
            }
        }
        else {
            Set<ProductImage> set = productImageDtoSetToProductImageSet( productDto.getProductImages() );
            if ( set != null ) {
                product.setProductImages( set );
            }
        }

        return product;
    }

    protected static Plantdescription plantdescriptionDtoToPlantdescription(PlantdescriptionDto plantdescriptionDto) {
        if ( plantdescriptionDto == null ) {
            return null;
        }

        Plantdescription plantdescription = new Plantdescription();

        plantdescription.setSun( plantdescriptionDto.getSun() );
        plantdescription.setSoil( plantdescriptionDto.getSoil() );
        plantdescription.setGrowthCycle( plantdescriptionDto.getGrowthCycle() );
        plantdescription.setGrowthRate( plantdescriptionDto.getGrowthRate() );
        plantdescription.setMaintenance( plantdescriptionDto.getMaintenance() );
        plantdescription.setWater( plantdescriptionDto.getWater() );

        return plantdescription;
    }

    protected static ProductImage productImageDtoToProductImage(ProductImageDto productImageDto) {
        if ( productImageDto == null ) {
            return null;
        }

        ProductImage productImage = new ProductImage();

        productImage.setImage( productImageDto.getImage() );

        return productImage;
    }

    protected static Set<ProductImage> productImageDtoSetToProductImageSet(Set<ProductImageDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductImage> set1 = new LinkedHashSet<ProductImage>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductImageDto productImageDto : set ) {
            set1.add( productImageDtoToProductImage( productImageDto ) );
        }

        return set1;
    }

    protected static PlantdescriptionDto plantdescriptionToPlantdescriptionDto(Plantdescription plantdescription) {
        if ( plantdescription == null ) {
            return null;
        }

        PlantdescriptionDto plantdescriptionDto = new PlantdescriptionDto();

        plantdescriptionDto.setSun( plantdescription.getSun() );
        plantdescriptionDto.setSoil( plantdescription.getSoil() );
        plantdescriptionDto.setGrowthCycle( plantdescription.getGrowthCycle() );
        plantdescriptionDto.setGrowthRate( plantdescription.getGrowthRate() );
        plantdescriptionDto.setMaintenance( plantdescription.getMaintenance() );
        plantdescriptionDto.setWater( plantdescription.getWater() );

        return plantdescriptionDto;
    }

    protected static ProductImageDto productImageToProductImageDto(ProductImage productImage) {
        if ( productImage == null ) {
            return null;
        }

        ProductImageDto productImageDto = new ProductImageDto();

        productImageDto.setImage( productImage.getImage() );

        return productImageDto;
    }

    protected static Set<ProductImageDto> productImageSetToProductImageDtoSet(Set<ProductImage> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductImageDto> set1 = new LinkedHashSet<ProductImageDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductImage productImage : set ) {
            set1.add( productImageToProductImageDto( productImage ) );
        }

        return set1;
    }

    protected static void plantdescriptionDtoToPlantdescription1(PlantdescriptionDto plantdescriptionDto, Plantdescription mappingTarget) {
        if ( plantdescriptionDto == null ) {
            return;
        }

        mappingTarget.setSun( plantdescriptionDto.getSun() );
        mappingTarget.setSoil( plantdescriptionDto.getSoil() );
        mappingTarget.setGrowthCycle( plantdescriptionDto.getGrowthCycle() );
        mappingTarget.setGrowthRate( plantdescriptionDto.getGrowthRate() );
        mappingTarget.setMaintenance( plantdescriptionDto.getMaintenance() );
        mappingTarget.setWater( plantdescriptionDto.getWater() );
    }
}
