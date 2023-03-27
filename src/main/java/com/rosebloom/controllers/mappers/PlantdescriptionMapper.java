package com.rosebloom.controllers.mappers;

import com.rosebloom.controllers.persistence.entities.Plantdescription;
import com.rosebloom.dtos.PlantdescriptionDto;

public class PlantdescriptionMapper {
    public Plantdescription toEntity(PlantdescriptionDto plantdescriptionDto) {
        return new Plantdescription(plantdescriptionDto.getSun(),plantdescriptionDto.getSoil()
        ,plantdescriptionDto.getGrowthCycle(),plantdescriptionDto.getGrowthCycle(),plantdescriptionDto.getMaintenance()
        ,plantdescriptionDto.getWater());
    }
    PlantdescriptionDto toDto(Plantdescription plantdescription)
    {
        return new PlantdescriptionDto(plantdescription.getSun(),plantdescription.getSoil()
        ,plantdescription.getGrowthCycle(),plantdescription.getGrowthCycle(),plantdescription.getMaintenance()
        ,plantdescription.getWater());
    }
}
// import org.mapstruct.*;
// import org.mapstruct.Mapper;

// @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
// public interface PlantdescriptionMapper {
//     Plantdescription toEntity(PlantdescriptionDto plantdescriptionDto);

//     PlantdescriptionDto toDto(Plantdescription plantdescription);

//     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//     Plantdescription partialUpdate(PlantdescriptionDto plantdescriptionDto, @MappingTarget Plantdescription plantdescription);
// }