package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.Category;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.dtos.CategoryDto;
import com.rosebloom.dtos.ProductDto;

import java.util.LinkedHashSet;
import java.util.Set;

public class CategoryMapper {


    public static Category toEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDto.getCategoryId() );
        category.setCategoryName( categoryDto.getCategoryName() );
        category.setProducts( productDtoSetToProductSet( categoryDto.getProducts() ) );

        return category;
    }

    public static CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setCategoryName( category.getCategoryName() );
        categoryDto.setProducts( productSetToProductDtoSet( category.getProducts() ) );

        return categoryDto;
    }


    public static Category partialUpdate(CategoryDto categoryDto, Category category) {
        if ( categoryDto == null ) {
            return category;
        }

        if ( categoryDto.getCategoryId() != null ) {
            category.setCategoryId( categoryDto.getCategoryId() );
        }
        if ( categoryDto.getCategoryName() != null ) {
            category.setCategoryName( categoryDto.getCategoryName() );
        }
        if ( category.getProducts() != null ) {
            Set<Product> set = productDtoSetToProductSet( categoryDto.getProducts() );
            if ( set != null ) {
                category.getProducts().clear();
                category.getProducts().addAll( set );
            }
        }
        else {
            Set<Product> set = productDtoSetToProductSet( categoryDto.getProducts() );
            if ( set != null ) {
                category.setProducts( set );
            }
        }

        return category;
    }

    protected static Set<Product> productDtoSetToProductSet(Set<ProductDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Product> set1 = new LinkedHashSet<Product>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductDto productDto : set ) {
            set1.add( ProductMapper.toEntity( productDto ) );
        }

        return set1;
    }

    protected static Set<ProductDto> productSetToProductDtoSet(Set<Product> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductDto> set1 = new LinkedHashSet<ProductDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Product product : set ) {
            set1.add( ProductMapper.toDto( product ) );
        }

        return set1;
    }
}
