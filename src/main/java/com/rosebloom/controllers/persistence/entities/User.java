// default package
// Generated 14 Mar 2023, 16:06:02 by Hibernate Tools 6.1.7.Final
package com.rosebloom.controllers.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="rosebloom"
    , uniqueConstraints = @UniqueConstraint(columnNames="email") 
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String password;
     private String email;
     private String address;
     private Date birthdate;
     private String phone;
     private int creditLimit;
     private String job;
     private int isAdmin;
     private Integer isDeleted;
     private Set<Cart> carts = new HashSet(0);
     private Set<Orders> orderses = new HashSet(0);
     private Set<Category> categories = new HashSet(0);

    public User() {
    }

	
    public User(String name, String password, String email, String address, Date birthdate, String phone, int creditLimit, int isAdmin) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.isAdmin = isAdmin;
    }
    public User(String name, String password, String email, String address, Date birthdate, String phone, int creditLimit, String job, int isAdmin, Integer isDeleted, Set<Cart> carts, Set<Orders> orderses, Set<Category> categories) {
       this.name = name;
       this.password = password;
       this.email = email;
       this.address = address;
       this.birthdate = birthdate;
       this.phone = phone;
       this.creditLimit = creditLimit;
       this.job = job;
       this.isAdmin = isAdmin;
       this.isDeleted = isDeleted;
       this.carts = carts;
       this.orderses = orderses;
       this.categories = categories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="password", nullable=false, length=300)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", unique=true, nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="address", nullable=false, length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birthdate", nullable=false, length=10)
    public Date getBirthdate() {
        return this.birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    
    @Column(name="phone", nullable=false, length=45)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="creditLimit", nullable=false)
    public int getCreditLimit() {
        return this.creditLimit;
    }
    
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Column(name="job", length=45)
    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    
    @Column(name="isAdmin", nullable=false)
    public int getIsAdmin() {
        return this.isAdmin;
    }
    
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    @Column(name="isDeleted")
    public Integer getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Cart> getCarts() {
        return this.carts;
    }
    
    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_interest", catalog="rosebloom", joinColumns = { 
    @JoinColumn(name="user_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
    @JoinColumn(name="interest_category_id", nullable=false, updatable=false) })
    public Set<Category> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }




}

