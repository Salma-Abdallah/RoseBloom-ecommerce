package com.rosebloom.controllers.persistence.repository;

import com.rosebloom.controllers.enums.OrderStatus;
import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.OrderDetails;
import com.rosebloom.controllers.persistence.entities.Orders;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.User;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRepository {
    EntityManager entityManager;
    public OrderRepository(){
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }

    public CustomValidationMessage createNewOrder(Orders order, Integer userId){
        Double sum = 0.0;
        for(OrderDetails orderDetails: order.getOrderDetailses()){
            Product product = entityManager.find(Product.class,orderDetails.getProduct().getId());
            if(product==null)return new CustomValidationMessage(false,"Product Not Found\nplease replace your Order");
            if(orderDetails.getQuantity()>product.getQuantity()){
                return new CustomValidationMessage(false, product.getName()+"has only "+product.getQuantity()+" items left, please set your order again");
            }
            sum+=orderDetails.getQuantity()*product.getPrice();
        }

        User user = entityManager.find(User.class,userId);
        order.setUser(user);
        if(user==null)return new CustomValidationMessage(false,"User Not Found\nplease sign in once again");
        if (user.getCreditLimit()<sum) return  new CustomValidationMessage(false, "Your Credit limit is not sufficient\nYour Credit Limit is: EGP "+user.getCreditLimit()+"\nthis order requires: EGP "+sum );
        order.setStatus(OrderStatus.PROCESSING.name());
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }

    public CustomValidationMessage changeOrderStatus(Integer orderId, OrderStatus status){
        Orders order = entityManager.find(Orders.class,orderId);
        if(order==null)return new CustomValidationMessage(false,"Order Not Found");
        order.setStatus(status.name());

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }

    public List<Orders> getAllOrders(){
        String query ="from Orders o";
        Query q = entityManager.createQuery(query);

        List<Orders> orders =(List<Orders>) q.getResultList();

        return orders;
    }
}

