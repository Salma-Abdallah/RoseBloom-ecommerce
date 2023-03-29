package com.rosebloom.controllers.persistence.repository;

import com.rosebloom.controllers.enums.OrderStatus;
import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;
import com.rosebloom.controllers.persistence.entities.Cart;
import com.rosebloom.controllers.persistence.entities.CartId;
import com.rosebloom.controllers.persistence.entities.Product;
import com.rosebloom.controllers.utils.CustomValidationMessage;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    EntityManager entityManager;
    public CartRepository(){
        entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
    }

    public CustomValidationMessage addCartItem(CartId cartId, Integer quantity){
        //check if cart Item prev exists
        Cart cartItem = null;
        Cart oldCartItem = entityManager.find(Cart.class,cartId);
        if(oldCartItem!=null){
            if(oldCartItem.getIsDeleted()==0)oldCartItem.setQuantity(quantity + oldCartItem.getQuantity());
            else oldCartItem.setQuantity(quantity);
            cartItem=oldCartItem;
        }else{
            cartItem = new Cart();
            cartItem.setId(cartId);
            cartItem.setQuantity(quantity);
        }

        //check quantity available
        Product product = entityManager.find(Product.class,cartItem.getId().getProductId());
        if(product==null)return new CustomValidationMessage(false,"Product Not Found\nplease replace your Order");
        if(product.getQuantity()<1) return new CustomValidationMessage(false,"Product Out of Stock\nplease replace your Order");
        if(product.getQuantity()<cartItem.getQuantity())return new CustomValidationMessage(false,"Only "+product.getQuantity()+" items are left in stock");
        cartItem.setIsDeleted(0);

        //save
        entityManager.getTransaction().begin();
        entityManager.persist(cartItem);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }
    public List<Cart> getAllCartItemsByUserId(Integer userId){
        List<Cart> cartItemList = entityManager.createQuery("from Cart c where c.isDeleted=0 and c.id.userId="+userId).getResultList();

        cartItemList.forEach((cartItem)->{
            if(cartItem.getQuantity()>cartItem.getProduct().getQuantity())cartItem.setQuantity(cartItem.getProduct().getQuantity());
        });

        if(cartItemList==null)cartItemList= new ArrayList<>();
        return cartItemList;
    }
    public CustomValidationMessage deleteCartItemByCartId(CartId cartId){
        Cart cartItem = entityManager.find(Cart.class, cartId);
        if(cartItem==null)return new CustomValidationMessage(false,"Cart Item Not Found");
        cartItem.setIsDeleted(1);

        entityManager.getTransaction().begin();
        entityManager.persist(cartItem);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }
    public CustomValidationMessage changeCartItemQuantity(CartId cartId,Integer quantity ){
        Product product = entityManager.find(Product.class,cartId.getProductId());
        if(product==null)return new CustomValidationMessage(false,"Product Not Found");

        Cart cartItem = entityManager.find(Cart.class, cartId);
        if(cartItem==null)return new CustomValidationMessage(false,"Cart Item Not Found");

        CustomValidationMessage customValidationMessage = new CustomValidationMessage(true,null);
        if(product.getQuantity()<quantity){
            quantity= product.getQuantity();
            System.out.println("in");
            customValidationMessage.setMessage("Max Number available is :"+cartItem.getProduct().getQuantity());
        }
        cartItem.setQuantity(quantity);
        System.out.println(customValidationMessage);
        entityManager.getTransaction().begin();
        entityManager.persist(cartItem);
        entityManager.getTransaction().commit();
        return customValidationMessage;
    }

    public CustomValidationMessage EmptyCart(int userId){
        List<Cart> cartList = entityManager.createQuery("from Cart c where c.isDeleted=0 and c.id.userId ="+userId).getResultList();
        for(Cart cartItem:cartList){
            cartItem.setIsDeleted(1);
        }
        entityManager.getTransaction().begin();
        for(Cart cartItem:cartList)entityManager.persist(cartItem);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }

    public CustomValidationMessage DeleteCartFromDB(int userId){
        List<Cart> cartList = entityManager.createQuery("from Cart c where c.isDeleted=0 and c.id.userId ="+userId).getResultList();
        entityManager.getTransaction().begin();
        for(Cart cartItem:cartList)entityManager.remove(cartItem);
        entityManager.getTransaction().commit();
        return new CustomValidationMessage(true,null);
    }

    
}
