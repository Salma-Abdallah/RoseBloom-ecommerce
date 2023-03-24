package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.User;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link User} entity
 */
public class UserDto implements Serializable {
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
    private Set<CartDto> carts;
    private Set<OrdersDto> orderses;
    private Set<CategoryDto> categories;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String password, String email, String address, Date birthdate, String phone, int creditLimit, String job, int isAdmin, Integer isDeleted, Set<CartDto> carts, Set<OrdersDto> orderses, Set<CategoryDto> categories) {
        this.id = id;
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

    public UserDto(String name, String password, String email, String address, Date birthdate, String phone, int creditLimit) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.phone = phone;
        this.creditLimit = creditLimit;
    }

    public UserDto(Integer id,String name, String password, String email, String address, Date birthdate, String phone, int creditLimit, String job) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<CartDto> getCarts() {
        return carts;
    }

    public void setCarts(Set<CartDto> carts) {
        this.carts = carts;
    }

    public Set<OrdersDto> getOrderses() {
        return orderses;
    }

    public void setOrderses(Set<OrdersDto> orderses) {
        this.orderses = orderses;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.birthdate, entity.birthdate) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.creditLimit, entity.creditLimit) &&
                Objects.equals(this.job, entity.job) &&
                Objects.equals(this.carts, entity.carts) &&
                Objects.equals(this.orderses, entity.orderses) &&
                Objects.equals(this.categories, entity.categories);
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, address, birthdate, phone, creditLimit, job, carts, orderses, categories);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", phone='" + phone + '\'' +
                ", creditLimit=" + creditLimit +
                ", job='" + job + '\'' +
                ", isAdmin=" + isAdmin +
                ", isDeleted=" + isDeleted +
                ", carts=" + carts +
                ", orderses=" + orderses +
                ", categories=" + categories +
                '}';
    }
}