package com.rosebloom.controllers.mappers;

import com.rosebloom.dtos.PlantdescriptionDto;
import com.rosebloom.controllers.persistence.entities.Plantdescription;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PlantdescriptionMapper {
    Plantdescription toEntity(PlantdescriptionDto plantdescriptionDto);

    PlantdescriptionDto toDto(Plantdescription plantdescription);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Plantdescription partialUpdate(PlantdescriptionDto plantdescriptionDto, @MappingTarget Plantdescription plantdescription);
}