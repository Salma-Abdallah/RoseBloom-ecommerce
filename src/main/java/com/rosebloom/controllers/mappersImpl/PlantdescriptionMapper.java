package com.rosebloom.controllers.mappersImpl;

import com.rosebloom.controllers.persistence.entities.Plantdescription;
import com.rosebloom.dtos.PlantdescriptionDto;

public class PlantdescriptionMapper {
    
    public static Plantdescription toEntity(PlantdescriptionDto plantdescriptionDto) {
        if ( plantdescriptionDto == null ) {
            return null;
        }

        Plantdescription plantdescription = new Plantdescription();

        plantdescription.setSun( plantdescriptionDto.getSun() );
        plantdescription.setSoil( plantdescriptionDto.getSoil() );
        plantdescription.setGrowthCycle( plantdescriptionDto.getGrowthCycle() );
        plantdescription.setGrowthRate( plantdescriptionDto.getGrowthRate() );
        plantdescription.setMaintenance( plantdescriptionDto.getMaintenance() );
        plantdescription.setWater( plantdescriptionDto.getWater() );

        return plantdescription;
    }
    
    public static PlantdescriptionDto toDto(Plantdescription plantdescription) {
        if ( plantdescription == null ) {
            return null;
        }

        PlantdescriptionDto plantdescriptionDto = new PlantdescriptionDto();

        plantdescriptionDto.setSun( plantdescription.getSun() );
        plantdescriptionDto.setSoil( plantdescription.getSoil() );
        plantdescriptionDto.setGrowthCycle( plantdescription.getGrowthCycle() );
        plantdescriptionDto.setGrowthRate( plantdescription.getGrowthRate() );
        plantdescriptionDto.setMaintenance( plantdescription.getMaintenance() );
        plantdescriptionDto.setWater( plantdescription.getWater() );

        return plantdescriptionDto;
    }
    
    public static Plantdescription partialUpdate(PlantdescriptionDto plantdescriptionDto, Plantdescription plantdescription) {
        if ( plantdescriptionDto == null ) {
            return plantdescription;
        }

        if ( plantdescriptionDto.getSun() != null ) {
            plantdescription.setSun( plantdescriptionDto.getSun() );
        }
        if ( plantdescriptionDto.getSoil() != null ) {
            plantdescription.setSoil( plantdescriptionDto.getSoil() );
        }
        if ( plantdescriptionDto.getGrowthCycle() != null ) {
            plantdescription.setGrowthCycle( plantdescriptionDto.getGrowthCycle() );
        }
        if ( plantdescriptionDto.getGrowthRate() != null ) {
            plantdescription.setGrowthRate( plantdescriptionDto.getGrowthRate() );
        }
        if ( plantdescriptionDto.getMaintenance() != null ) {
            plantdescription.setMaintenance( plantdescriptionDto.getMaintenance() );
        }
        if ( plantdescriptionDto.getWater() != null ) {
            plantdescription.setWater( plantdescriptionDto.getWater() );
        }

        return plantdescription;
    }
}
