package com.rosebloom.dtos;

import com.rosebloom.controllers.persistence.entities.Plantdescription;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Plantdescription} entity
 */
public class PlantdescriptionDto implements Serializable {
    private String sun;
    private String soil;
    private String growthCycle;
    private String growthRate;
    private String maintenance;
    private String water;

    public PlantdescriptionDto() {
    }

    public PlantdescriptionDto(String sun, String soil, String growthCycle, String growthRate, String maintenance, String water) {
        this.sun = sun;
        this.soil = soil;
        this.growthCycle = growthCycle;
        this.growthRate = growthRate;
        this.maintenance = maintenance;
        this.water = water;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantdescriptionDto entity = (PlantdescriptionDto) o;
        return Objects.equals(this.sun, entity.sun) &&
                Objects.equals(this.soil, entity.soil) &&
                Objects.equals(this.growthCycle, entity.growthCycle) &&
                Objects.equals(this.growthRate, entity.growthRate) &&
                Objects.equals(this.maintenance, entity.maintenance) &&
                Objects.equals(this.water, entity.water);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sun, soil, growthCycle, growthRate, maintenance, water);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "sun = " + sun + ", " +
                "soil = " + soil + ", " +
                "growthCycle = " + growthCycle + ", " +
                "growthRate = " + growthRate + ", " +
                "maintenance = " + maintenance + ", " +
                "water = " + water + ")";
    }
}