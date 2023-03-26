package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.OrderDetails;
import com.rosebloom.controllers.persistence.entities.Orders;
import com.rosebloom.dtos.OrderDetailsDto;
import com.rosebloom.dtos.OrdersDto;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrdersMapper {


    public static Orders toEntity(OrdersDto ordersDto) {
        if ( ordersDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( ordersDto.getOrderId() );
        orders.setOrderDate( ordersDto.getOrderDate() );
        orders.setAddress( ordersDto.getAddress() );
        orders.setStatus( ordersDto.getStatus() );
        orders.setOrderDetailses( orderDetailsDtoSetToOrderDetailsSet( ordersDto.getOrderDetailses() ) );

        linkOrderDetailses( orders );

        return orders;
    }

    public static OrdersDto toDto(Orders orders) {
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

    public static Orders partialUpdate(OrdersDto ordersDto, Orders orders) {
        if ( ordersDto == null ) {
            return orders;
        }

        if ( ordersDto.getOrderId() != null ) {
            orders.setOrderId( ordersDto.getOrderId() );
        }
        if ( ordersDto.getOrderDate() != null ) {
            orders.setOrderDate( ordersDto.getOrderDate() );
        }
        if ( ordersDto.getAddress() != null ) {
            orders.setAddress( ordersDto.getAddress() );
        }
        if ( ordersDto.getStatus() != null ) {
            orders.setStatus( ordersDto.getStatus() );
        }
        if ( orders.getOrderDetailses() != null ) {
            Set<OrderDetails> set = orderDetailsDtoSetToOrderDetailsSet( ordersDto.getOrderDetailses() );
            if ( set != null ) {
                orders.getOrderDetailses().clear();
                orders.getOrderDetailses().addAll( set );
            }
        }
        else {
            Set<OrderDetails> set = orderDetailsDtoSetToOrderDetailsSet( ordersDto.getOrderDetailses() );
            if ( set != null ) {
                orders.setOrderDetailses( set );
            }
        }

        linkOrderDetailses( orders );

        return orders;
    }

    protected static Set<OrderDetails> orderDetailsDtoSetToOrderDetailsSet(Set<OrderDetailsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetails> set1 = new LinkedHashSet<OrderDetails>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetailsDto orderDetailsDto : set ) {
            set1.add( OrderDetailsMapper.toEntity( orderDetailsDto ) );
        }

        return set1;
    }

    protected static Set<OrderDetailsDto> orderDetailsSetToOrderDetailsDtoSet(Set<OrderDetails> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetailsDto> set1 = new LinkedHashSet<OrderDetailsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetails orderDetails : set ) {
            set1.add( OrderDetailsMapper.toDto( orderDetails ) );
        }

        return set1;
    }
    protected static void linkOrderDetailses(Orders orders) {
        if(orders.getOrderDetailses()!=null)orders.getOrderDetailses().forEach(orderDetails -> orderDetails.setOrders(orders));
    }
}
