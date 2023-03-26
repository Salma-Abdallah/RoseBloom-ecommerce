package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.*;
import com.rosebloom.dtos.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setAddress( userDto.getAddress() );
        user.setBirthdate( userDto.getBirthdate() );
        user.setPhone( userDto.getPhone() );
        user.setCreditLimit( userDto.getCreditLimit() );
        user.setJob( userDto.getJob() );
        user.setCarts( cartDtoSetToCartSet( userDto.getCarts() ) );
        user.setOrderses( ordersDtoSetToOrdersSet( userDto.getOrderses() ) );
        user.setCategories( categoryDtoSetToCategorySet( userDto.getCategories() ) );

        linkCarts( user );
        linkOrderses( user );

        return user;
    }

    public static UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setAddress( user.getAddress() );
        userDto.setBirthdate( user.getBirthdate() );
        userDto.setPhone( user.getPhone() );
        userDto.setCreditLimit( user.getCreditLimit() );
        userDto.setJob( user.getJob() );
        userDto.setCarts( cartSetToCartDtoSet( user.getCarts() ) );
        userDto.setOrderses( ordersSetToOrdersDtoSet( user.getOrderses() ) );
        userDto.setCategories( categorySetToCategoryDtoSet( user.getCategories() ) );

        return userDto;
    }

    public static User partialUpdate(UserDto userDto, User user) {
        if ( userDto == null ) {
            return user;
        }

        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( userDto.getName() != null ) {
            user.setName( userDto.getName() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
        if ( userDto.getEmail() != null ) {
            user.setEmail( userDto.getEmail() );
        }
        if ( userDto.getAddress() != null ) {
            user.setAddress( userDto.getAddress() );
        }
        if ( userDto.getBirthdate() != null ) {
            user.setBirthdate( userDto.getBirthdate() );
        }
        if ( userDto.getPhone() != null ) {
            user.setPhone( userDto.getPhone() );
        }
        user.setCreditLimit( userDto.getCreditLimit() );
        if ( userDto.getJob() != null ) {
            user.setJob( userDto.getJob() );
        }
        if ( user.getCarts() != null ) {
            Set<Cart> set = cartDtoSetToCartSet( userDto.getCarts() );
            if ( set != null ) {
                user.getCarts().clear();
                user.getCarts().addAll( set );
            }
        }
        else {
            Set<Cart> set = cartDtoSetToCartSet( userDto.getCarts() );
            if ( set != null ) {
                user.setCarts( set );
            }
        }
        if ( user.getOrderses() != null ) {
            Set<Orders> set1 = ordersDtoSetToOrdersSet( userDto.getOrderses() );
            if ( set1 != null ) {
                user.getOrderses().clear();
                user.getOrderses().addAll( set1 );
            }
        }
        else {
            Set<Orders> set1 = ordersDtoSetToOrdersSet( userDto.getOrderses() );
            if ( set1 != null ) {
                user.setOrderses( set1 );
            }
        }
        if ( user.getCategories() != null ) {
            Set<Category> set2 = categoryDtoSetToCategorySet( userDto.getCategories() );
            if ( set2 != null ) {
                user.getCategories().clear();
                user.getCategories().addAll( set2 );
            }
        }
        else {
            Set<Category> set2 = categoryDtoSetToCategorySet( userDto.getCategories() );
            if ( set2 != null ) {
                user.setCategories( set2 );
            }
        }

        linkCarts( user );
        linkOrderses( user );

        return user;
    }

    protected static CartId cartIdDtoToCartId(CartIdDto cartIdDto) {
        if ( cartIdDto == null ) {
            return null;
        }

        CartId cartId = new CartId();

        cartId.setProductId( cartIdDto.getProductId() );
        cartId.setUserId( cartIdDto.getUserId() );

        return cartId;
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

    protected static Product productDtoToProduct(ProductDto productDto) {
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

    protected static Cart cartDtoToCart(CartDto cartDto) {
        if ( cartDto == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( cartIdDtoToCartId( cartDto.getId() ) );
        cart.setProduct( productDtoToProduct( cartDto.getProduct() ) );
//        cart.setUser( toEntity( cartDto.getUser() ) );
        cart.setQuantity( cartDto.getQuantity() );

        return cart;
    }

    protected static Set<Cart> cartDtoSetToCartSet(Set<CartDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Cart> set1 = new LinkedHashSet<Cart>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CartDto cartDto : set ) {
            set1.add( cartDtoToCart( cartDto ) );
        }

        return set1;
    }

    protected static OrderDetails orderDetailsDtoToOrderDetails(OrderDetailsDto orderDetailsDto) {
        if ( orderDetailsDto == null ) {
            return null;
        }

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setProduct( productDtoToProduct( orderDetailsDto.getProduct() ) );
        orderDetails.setQuantity( orderDetailsDto.getQuantity() );
        orderDetails.setPrice( orderDetailsDto.getPrice() );

        return orderDetails;
    }

    protected static Set<OrderDetails> orderDetailsDtoSetToOrderDetailsSet(Set<OrderDetailsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetails> set1 = new LinkedHashSet<OrderDetails>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetailsDto orderDetailsDto : set ) {
            set1.add( orderDetailsDtoToOrderDetails( orderDetailsDto ) );
        }

        return set1;
    }

    protected static Orders ordersDtoToOrders(OrdersDto ordersDto) {
        if ( ordersDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( ordersDto.getOrderId() );
        orders.setOrderDate( ordersDto.getOrderDate() );
        orders.setAddress( ordersDto.getAddress() );
        orders.setStatus( ordersDto.getStatus() );
        orders.setOrderDetailses( orderDetailsDtoSetToOrderDetailsSet( ordersDto.getOrderDetailses() ) );

        return orders;
    }

    protected static Set<Orders> ordersDtoSetToOrdersSet(Set<OrdersDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new LinkedHashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersDto ordersDto : set ) {
            set1.add( ordersDtoToOrders( ordersDto ) );
        }

        return set1;
    }

    protected static Set<Product> productDtoSetToProductSet(Set<ProductDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Product> set1 = new LinkedHashSet<Product>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductDto productDto : set ) {
            set1.add( productDtoToProduct( productDto ) );
        }

        return set1;
    }

    protected static Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDto.getCategoryId() );
        category.setCategoryName( categoryDto.getCategoryName() );
        category.setProducts( productDtoSetToProductSet( categoryDto.getProducts() ) );

        return category;
    }

    protected static Set<Category> categoryDtoSetToCategorySet(Set<CategoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Category> set1 = new LinkedHashSet<Category>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoryDto categoryDto : set ) {
            set1.add( categoryDtoToCategory( categoryDto ) );
        }

        return set1;
    }

    protected static CartIdDto cartIdToCartIdDto(CartId cartId) {
        if ( cartId == null ) {
            return null;
        }

        CartIdDto cartIdDto = new CartIdDto();

        cartIdDto.setProductId( cartId.getProductId() );
        cartIdDto.setUserId( cartId.getUserId() );

        return cartIdDto;
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

    protected static ProductDto productToProductDto(Product product) {
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

    protected static CartDto cartToCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cartIdToCartIdDto( cart.getId() ) );
        cartDto.setProduct( productToProductDto( cart.getProduct() ) );
//        cartDto.setUser( toDto( cart.getUser() ) );
        cartDto.setQuantity( cart.getQuantity() );

        return cartDto;
    }

    protected static Set<CartDto> cartSetToCartDtoSet(Set<Cart> set) {
        if ( set == null ) {
            return null;
        }

        Set<CartDto> set1 = new LinkedHashSet<CartDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Cart cart : set ) {
            set1.add( cartToCartDto( cart ) );
        }

        return set1;
    }

    protected static OrderDetailsDto orderDetailsToOrderDetailsDto(OrderDetails orderDetails) {
        if ( orderDetails == null ) {
            return null;
        }

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        orderDetailsDto.setProduct( productToProductDto( orderDetails.getProduct() ) );
        orderDetailsDto.setQuantity( orderDetails.getQuantity() );
        orderDetailsDto.setPrice( orderDetails.getPrice() );

        return orderDetailsDto;
    }

    protected static Set<OrderDetailsDto> orderDetailsSetToOrderDetailsDtoSet(Set<OrderDetails> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetailsDto> set1 = new LinkedHashSet<OrderDetailsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetails orderDetails : set ) {
            set1.add( orderDetailsToOrderDetailsDto( orderDetails ) );
        }

        return set1;
    }

    protected static OrdersDto ordersToOrdersDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setOrderId( orders.getOrderId() );
        ordersDto.setOrderDate( orders.getOrderDate() );
        ordersDto.setAddress( orders.getAddress() );
        ordersDto.setStatus( orders.getStatus() );
        ordersDto.setOrderDetailses( orderDetailsSetToOrderDetailsDtoSet( orders.getOrderDetailses() ) );

        return ordersDto;
    }

    protected static Set<OrdersDto> ordersSetToOrdersDtoSet(Set<Orders> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrdersDto> set1 = new LinkedHashSet<OrdersDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Orders orders : set ) {
            set1.add( ordersToOrdersDto( orders ) );
        }

        return set1;
    }

    protected static Set<ProductDto> productSetToProductDtoSet(Set<Product> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductDto> set1 = new LinkedHashSet<ProductDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Product product : set ) {
            set1.add( productToProductDto( product ) );
        }

        return set1;
    }

    protected static CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setCategoryName( category.getCategoryName() );
        categoryDto.setProducts( productSetToProductDtoSet( category.getProducts() ) );

        return categoryDto;
    }

    protected static Set<CategoryDto> categorySetToCategoryDtoSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryDto> set1 = new LinkedHashSet<CategoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Category category : set ) {
            set1.add( categoryToCategoryDto( category ) );
        }

        return set1;
    }

    protected static void linkCarts(User user) {
        if(user.getCarts()!=null)user.getCarts().forEach(cart -> cart.setUser(user));
    }


    protected static void linkOrderses(User user) {
        if(user.getOrderses()!=null)user.getOrderses().forEach(orders -> orders.setUser(user));
    }
}
