// default package
// Generated 14 Mar 2023, 16:06:02 by Hibernate Tools 6.1.7.Final
package com.rosebloom.controllers.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Plantdescription generated by hbm2java
 */
@Entity
@Table(name="plantdescription"
    ,catalog="rosebloom"
)
public class Plantdescription  implements java.io.Serializable {


    private int productId;
    private Product product;
    private String sun;
    private String soil;
    private String growthCycle;
    private String growthRate;
    private String maintenance;
    private String water;

    public Plantdescription(String sun, String soil, String growthCycle, String growthRate, String maintenance,
            String water) {
        this.sun = sun;
        this.soil = soil;
        this.growthCycle = growthCycle;
        this.growthRate = growthRate;
        this.maintenance = maintenance;
        this.water = water;
    }


    public Plantdescription(int productId, Product product, String sun, String soil, String growthCycle,
            String growthRate, String maintenance, String water) {
        this.productId = productId;
        this.product = product;
        this.sun = sun;
        this.soil = soil;
        this.growthCycle = growthCycle;
        this.growthRate = growthRate;
        this.maintenance = maintenance;
        this.water = water;
    }


    public Plantdescription() {
    }

	
    public Plantdescription(Product product) {
        this.product = product;
    }
    public Plantdescription(Product product, String sun, String soil, String growthCycle, String growthRate, String maintenance, String water) {
       this.product = product;
       this.sun = sun;
       this.soil = soil;
       this.growthCycle = growthCycle;
       this.growthRate = growthRate;
       this.maintenance = maintenance;
       this.water = water;
    }
   
     @GenericGenerator(name="PlantdescriptionIdGenerator", strategy="foreign", parameters=@Parameter(name="property", value="product"))@Id @GeneratedValue(generator="PlantdescriptionIdGenerator")

    
    @Column(name="product_id", unique=true, nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Column(name="sun", length=45)
    public String getSun() {
        return this.sun;
    }
    
    public void setSun(String sun) {
        this.sun = sun;
    }

    
    @Column(name="soil", length=45)
    public String getSoil() {
        return this.soil;
    }
    
    public void setSoil(String soil) {
        this.soil = soil;
    }

    
    @Column(name="growthCycle", length=45)
    public String getGrowthCycle() {
        return this.growthCycle;
    }
    
    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    
    @Column(name="growthRate", length=45)
    public String getGrowthRate() {
        return this.growthRate;
    }
    
    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    
    @Column(name="maintenance", length=45)
    public String getMaintenance() {
        return this.maintenance;
    }
    
    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    
    @Column(name="water", length=45)
    public String getWater() {
        return this.water;
    }
    
    public void setWater(String water) {
        this.water = water;
    }




}


