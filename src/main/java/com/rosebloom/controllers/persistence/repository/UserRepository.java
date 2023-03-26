package com.rosebloom.controllers.persistence.repository;

import com.rosebloom.controllers.persistence.connection.EntityManagerFactorySingleton;

import com.rosebloom.controllers.persistence.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class UserRepository {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager ;
    public UserRepository(){
        entityManager = entityManagerFactory.createEntityManager();
    }
    public void insertUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
    public User getUserByEmail(String email , String password) {
        String query="from User u where u.email like ?1 and u.password like ?2";
        Query q = entityManager.createQuery(query).setParameter(1,email).setParameter(2,password);
        User user =(User) q.getSingleResult();

        return user;
    }
    public Boolean checkIfUserIsValid(String email , String password) {
        String query = "from User u where u.email like ?1 and u.password like ?2";
        Query q = entityManager.createQuery(query).setParameter(1, email).setParameter(2, password);
        List list = q.getResultList();
//        Boolean result= list.size()>0;
        if(list.size()>0){
            return true;
        }

        return false;
    }

    public Boolean checkByEmailIfValid(String email) {
        String query="from User u where u.email like ?1";
        Query q = entityManager.createQuery(query).setParameter(1,email);

        List list = q.getResultList();
        Boolean result= list.size()>0;

        return result;
    }


    //Want to Check it by real data
    public void UpdateUserDetails(User user) {
        entityManager.getTransaction().begin();
        // Integer pk = user.getId();
        System.out.println(user.getId());

        User newUser = entityManager.find(User.class,user.getId());

        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());
        newUser.setBirthdate(user.getBirthdate());
        newUser.setCreditLimit(user.getCreditLimit());
        newUser.setJob(user.getJob());
        newUser.setIsAdmin(user.getIsAdmin());
        newUser.setIsDeleted(user.getIsDeleted());
        newUser.setCarts(user.getCarts());
        newUser.setOrderses(user.getOrderses());
        newUser.setCategories(user.getCategories());
        
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

        System.out.println("User id : "+user.getId());

    }

    public List<User> getAllUsers() {
        String query ="from User u ";
        Query q = entityManager.createQuery(query);
        List<User> users =(List<User>) q.getResultList();

        return users;
    }



}
