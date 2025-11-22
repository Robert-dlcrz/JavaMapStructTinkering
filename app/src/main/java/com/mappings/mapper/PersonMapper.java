package com.mappings.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mappings.dtos.PersonDTO;
import com.mappings.model.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDto(Person person);
}