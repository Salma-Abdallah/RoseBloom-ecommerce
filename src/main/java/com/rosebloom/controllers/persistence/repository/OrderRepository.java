package com.rosebloom.controllers.persistence.repository;

import com.rosebloom.controllers.enums.OrderStatus;
import com.rosebloom.controllers.mappers.ProductMapper;
import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.OrderDetails;
import com.rosebloom.controllers.persistence.entities.Orders;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.persistence.entities.User;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    EntityManager entityManager;
    public OrderRepository(){
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }

    public CustomValidationMessage createNewOrder(Orders order, Integer userId){
        //Calculate the sum of the cart
        Integer sum = 0;
        List<Product> CartProductList = new ArrayList<>();
        List<OrderDetails> orderDetailsList = new ArrayList<>(order.getOrderDetailses());
        for(OrderDetails orderDetails: orderDetailsList){
            Product product = entityManager.find(Product.class,orderDetails.getProduct().getId());
            if(product==null)return new CustomValidationMessage(false,"Product Not Found\nplease replace your Order");
            if(orderDetails.getQuantity()>product.getQuantity()){
                return new CustomValidationMessage(false, product.getName()+"has only "+product.getQuantity()+" items left, please set your order again");
            }
            CartProductList.add(product);
            sum+=orderDetails.getQuantity()*product.getPrice();
        }

        sum+=50; //FIXED SHIPPING FEE

        //Check users credit
        User user = entityManager.find(User.class,userId);
        order.setUser(user);
        if(user==null)return new CustomValidationMessage(false,"User Not Found\nplease sign in once again");
        if (user.getCreditLimit()<sum) return  new CustomValidationMessage(false, "Your Credit limit is not sufficient\nYour Credit Limit is: EGP "+user.getCreditLimit()+"\nthis order requires: EGP "+sum );

        //detect amount from user credit
        user.setCreditLimit(user.getCreditLimit() - sum);

        //empty userCart
        CartRepository cartRepository = new CartRepository();
        CustomValidationMessage customValidationMessage = cartRepository.DeleteCartFromDB(userId);
        if(!customValidationMessage.isSuccess()) return new CustomValidationMessage(false,"Place Order Failed\nplease try again");

        //reduce the available amount of all items in the cart from stock
        for(int i=0;i<CartProductList.size();i++){
            CartProductList.get(i).setQuantity(CartProductList.get(i).getQuantity()-orderDetailsList.get(i).getQuantity());
        }

        order.setStatus(OrderStatus.PROCESSING.name());
        order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));

        //save the changes
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.persist(user);
        for(Product product:CartProductList)entityManager.persist(product);
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
}

