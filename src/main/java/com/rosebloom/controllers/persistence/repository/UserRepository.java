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
    public User searchByEmail(String email) {
        String query="from User u where u.email like ?1";
        Query q = entityManager.createQuery(query).setParameter(1,email);
        User user =(User) q.getSingleResult();

        return user;
    }
    public boolean checkByEmailIfValid(String email) {
        String query="from User u where u.email like ?1";
        Query q = entityManager.createQuery(query).setParameter(1,email);

        List list = q.getResultList();
        boolean result= list.size()>0;

        return result;
    }


    //Want to Check it by real data
    public void UpdateInUserDetails(User user) {
        entityManager.getTransaction().begin();
        User newUser = entityManager.find(User.class,user.getId());
//        newUser = user;
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

    }

    public List<User> returnAllUsers() {
        String query ="from User u ";
        Query q = entityManager.createQuery(query);
        List<User> users =(List<User>) q.getResultList();

        return users;
    }

}
