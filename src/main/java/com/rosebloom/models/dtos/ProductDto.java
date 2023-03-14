package com.rosebloom.models.dtos;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {
    
    private Integer id;
    private int price;
    private String name;
    private int quantity;
    private String type;
    private String category;
    private String description;
    private String color;
    private Integer size;
    private Integer isDeleted;
    // private Plantdescription plantdescription;
    // private Set<Cart> carts = new HashSet(0);
    // private Set<OrderDetails> orderDetailses = new HashSet(0);
    // private Set<ProductImage> productImages = new HashSet(0);
     private Set<CategoryDto> categories = new HashSet<>();

    public ProductDto() {
    }

	
    public ProductDto(int price, String name, int quantity, String type, String category, String description) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.category = category;
        this.description = description;
    }
    public ProductDto(int price, String name, int quantity, String type, String category, String description, String color, Integer size, Integer isDeleted) {
       this.price = price;
       this.name = name;
       this.quantity = quantity;
       this.type = type;
       this.category = category;
       this.description = description;
       this.color = color;
       this.size = size;
       this.isDeleted = isDeleted;
  
     }
   
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
 
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    
   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
 
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
  
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    
   
    public Integer getSize() {
        return this.size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }

    
  
    public Integer getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

  
    // public Plantdescription getPlantdescription() {
    //     return this.plantdescription;
    // }
    
    // public void setPlantdescription(Plantdescription plantdescription) {
    //     this.plantdescription = plantdescription;
    // }

   
    // public Set<Cart> getCarts() {
    //     return this.carts;
    // }
    
    // public void setCarts(Set<Cart> carts) {
    //     this.carts = carts;
    // }

   
    // public Set<OrderDetails> getOrderDetailses() {
    //     return this.orderDetailses;
    // }
    
    // public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
    //     this.orderDetailses = orderDetailses;
    // }

   
    // public Set<ProductImage> getProductImages() {
    //     return this.productImages;
    // }
    
    // public void setProductImages(Set<ProductImage> productImages) {
    //     this.productImages = productImages;
    // }

   
    // public Set<Category> getCategories() {
    //     return this.categories;
    // }
    
    // public void setCategories(Set<Category> categories) {
    //     this.categories = categories;
    // }


}
