package com.mappings.quick_bites.map_struct_quick_bite_1;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


/**
 * IMPORTANT: See the README.md in the unit test folder to understand the importance of 
 * unmappedTargetPolicy = ReportingPolicy.ERROR
 */
@Mapper // (unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PersonWithAddressMapper {
    PersonWithAddressMapper INSTANCE = Mappers.getMapper(PersonWithAddressMapper.class);

    // Only define the main mapping method
    // MapStruct will automatically CREATE the Address -> AddressssDTO mapping!
    PersonWithAddressDTO toDto(PersonWithAddress person);
}

